/*
 * Copyright 2011, TAUTUA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.tautua.boson.json.core;

import org.tautua.boson.json.TypeAdapterRegistry;
import org.tautua.boson.json.TypeAdapter;
import org.tautua.boson.json.core.adapters.*;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Larry Ruiz
 */
public class TypeAdapterRegistryImpl implements TypeAdapterRegistry {
    private Map<Class<?>, TypeAdapter> typeAdapters = new HashMap<Class<?>, TypeAdapter>();
    private Map<Class<?>, ContainerAdapterFactory> adapterFactoriesMap = new HashMap<Class<?>, ContainerAdapterFactory>();
    private ParameterizedAdapterFactory beanAdapterFactory;
    private ContainerAdapterFactory arrayAdapterFactory;
    private ParameterizedAdapterFactory enumAdapterFactory;


    public TypeAdapterRegistryImpl() {
        // BASIC VALUE TYPES
        new StringAdapter().register(this);
        new CharacterAdapter().register(this);
        new BooleanAdapter().register(this);
        new NumberAdapter.ByteAdapter().register(this);
        new NumberAdapter.ShortAdapter().register(this);
        new NumberAdapter.IntegerAdapter().register(this);
        new NumberAdapter.LongAdapter().register(this);
        new NumberAdapter.FloatAdapter().register(this);
        new NumberAdapter.DoubleAdapter().register(this);

        new UnknownTypeAdapter().register(this);

        //BASIC CONTAINER TYPE
        new ListAdapterFactory().register(this);
        new SetAdapterFactory().register(this);
        new MapAdapterFactory().register(this);

        arrayAdapterFactory = new ArrayAdapterFactory();
        beanAdapterFactory = new BeanAdapterFactory();
        enumAdapterFactory = new EnumAdapterFactory();
    }

    @SuppressWarnings({"unchecked"})
    public <T> TypeAdapter<T> findAdapter(Class<T> type) {
        return (TypeAdapter<T>) findTypeAdapter(TypeInfo.describe(type));
    }

    public TypeAdapter<?> findAdapter(Field field) {
        return findTypeAdapter(TypeInfo.describe(field));
    }

    protected TypeAdapter<?> findTypeAdapter(TypeInfo typeInfo) {
        TypeAdapter<?> typeAdapter;
        if (typeInfo.isEnum()) {
            typeAdapter = enumAdapterFactory.create(typeInfo.getRawType());
        } else if (typeInfo.hasAugmentations()) {
            if (typeInfo.isArray()) {
                typeAdapter = arrayAdapterFactory.create(checkAndGetContainedType(typeInfo));
            } else {
                ContainerAdapterFactory f = adapterFactoriesMap.get(typeInfo.getRawType());
                typeAdapter = f.create(checkAndGetContainedType(typeInfo));
            }
        } else {
            typeAdapter = typeAdapters.get(typeInfo.getRawType());
            if (typeAdapter == null) {
                typeAdapter = beanAdapterFactory.create(typeInfo.getRawType());
            }
        }
        return typeAdapter;
    }

    protected Class<?> checkAndGetContainedType(TypeInfo typeInfo) {
        Class<?> containedType;
        Type[] types = typeInfo.getActualTypeAugmentations();
        if (types[0] instanceof Class) {
            containedType = (Class) types[0];
        } else {
            //TODO: add message o provide custom exception
            throw new IllegalArgumentException();
        }

        return containedType;
    }

    public void setBeanAdapterFactory(ParameterizedAdapterFactory beanAdapterFactory) {
        this.beanAdapterFactory = beanAdapterFactory;
    }

    public void setEnumAdapterFactory(ParameterizedAdapterFactory enumAdapterFactory) {
        this.enumAdapterFactory = enumAdapterFactory;
    }

    public void setArrayAdapterFactory(ContainerAdapterFactory arrayAdapterFactory) {
        this.arrayAdapterFactory = arrayAdapterFactory;
    }

    public void register(Class type, TypeAdapter typeAdapter) {
        typeAdapters.put(type, typeAdapter);        
    }

    public void register(Class type, ContainerAdapterFactory adapterFactory) {
        adapterFactoriesMap.put(type, adapterFactory);
    }

    /**
     * @author Larry Ruiz
     */
    public abstract static class Component {
        public void register(TypeAdapterRegistryImpl adapterManager){
            throw new UnsupportedOperationException();            
        }
    }
}
