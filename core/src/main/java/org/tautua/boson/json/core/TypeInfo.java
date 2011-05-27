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

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * @author Larry Ruiz
 */
public class TypeInfo {
    private Class<?> rawType;
    private Type[] typeParameters;
    private Type[] actualTypeAugmentations;

    public Class<?> getRawType() {
        return rawType;
    }

    public Type[] getActualTypeAugmentations() {
        return actualTypeAugmentations;
    }

    public boolean hasAugmentations() {
        return actualTypeAugmentations != null && actualTypeAugmentations.length > 0;
    }

    public boolean isArray() {
        return rawType.isArray();
    }

    public boolean isPrimitive() {
        return rawType.isPrimitive();
    }

    public boolean isEnum() {
        return rawType.isEnum();
    }

    public static TypeInfo describe(Field field) {
        TypeInfo ti;
        if (field.getGenericType() instanceof GenericArrayType) {
            ti = new TypeInfo();
            ti.rawType = field.getType();
            ti.actualTypeAugmentations = new Type[]{((GenericArrayType) field.getGenericType()).getGenericComponentType()};
        } else if (field.getGenericType() instanceof ParameterizedType) {
            ti = new TypeInfo();
            ti.rawType = field.getType();
            Type[] temp = ((ParameterizedType) field.getGenericType()).getActualTypeArguments();
            ti.actualTypeAugmentations = new Type[temp.length];
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] instanceof GenericArrayType) {
                    Class<?> componentType = Array.newInstance(
                            (Class<?>) ((GenericArrayType) temp[i]).getGenericComponentType(), 0).getClass();
                    ti.actualTypeAugmentations[i] = componentType;
                } else {
                    ti.actualTypeAugmentations[i] = temp[i];
                }
            }
        } else {
            ti = describe(field.getType());
        }
        return ti;
    }

    public static TypeInfo describe(Class<?> type) {
        TypeInfo ti = new TypeInfo();
        ti.rawType = type;
        if (type.isArray()) {
            ti.actualTypeAugmentations = new Type[]{type.getComponentType()};
        } else if (type.getTypeParameters() != null && type.getTypeParameters().length > 0) {
            ti.typeParameters = type.getTypeParameters();

            ti.actualTypeAugmentations = new Type[ti.typeParameters.length];
            Arrays.fill(ti.actualTypeAugmentations, Object.class);
        }

        return ti;
    }

    public String toString() {
        StringBuilder buff = new StringBuilder();
        if (isArray()) {
            buff.append(((Class) actualTypeAugmentations[0]).getSimpleName()).append("[]");
        } else {
            buff.append(rawType.getSimpleName());
            if (hasAugmentations()) {
                buff.append("<");
                for (int i = 0; i < actualTypeAugmentations.length; i++) {
                    Type t = actualTypeAugmentations[i];
                    if (t instanceof Class) {
                        Class c = (Class) t;
                        if (c.isArray()) {
                            buff.append(c.getComponentType().getSimpleName()).append("[]");
                        } else {
                            buff.append(c.getSimpleName());
                        }
                    } else if (t instanceof TypeVariable) {
                        TypeVariable tv = (TypeVariable) t;
                        buff.append(tv.getName());
                    }
                    if (i < actualTypeAugmentations.length - 1) {
                        buff.append(", ");
                    }
                }
                buff.append(">");
            }
        }
        return buff.toString();
    }
}
