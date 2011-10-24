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
import org.tautua.boson.json.core.adapters.*;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Larry Ruiz
 */
public class TypeAdapterRegistryImpl implements TypeAdapterRegistry {
    private Map<Class<?>, LiteralAdapter> literalAdapters = new HashMap<Class<?>, LiteralAdapter>();
    private Map<Class<?>, ContainerAdapter> containerAdapters = new HashMap<Class<?>, ContainerAdapter>();


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


        //BASIC CONTAINER TYPE
    }

    @SuppressWarnings({"unchecked"})
    public <T> LiteralAdapter<T> findLiteralAdapter(Class<T> type) {
        if(type.isEnum()) {
            return new EnumAdapter(type);
        }
        return literalAdapters.get(type);
    }

    public ContainerAdapter findContainerAdapter(Class<?> containerType) {
        if(containerType.isArray()) {
            return new ArrayAdapter(containerType.getComponentType());
        } else if(Set.class.isAssignableFrom(containerType)) {
            return new SetAdapter(Object.class);
        } else if(Collection.class.isAssignableFrom(containerType)) {
            return new ListAdapter(Object.class);
        }
        
        throw new IllegalArgumentException("Not an array or collection");
    }

    public void register(Class type, LiteralAdapter literalAdapter) {
        literalAdapters.put(type, literalAdapter);        
    }

    /**
     * @author Larry Ruiz
     */
    @Deprecated
    public abstract static class Component {
        public void register(TypeAdapterRegistryImpl adapterManager){
            throw new UnsupportedOperationException();            
        }
    }
}
