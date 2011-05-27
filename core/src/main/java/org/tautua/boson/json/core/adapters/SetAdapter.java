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

package org.tautua.boson.json.core.adapters;

import org.tautua.boson.json.Context;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Larry Ruiz
 */
public class SetAdapter<E> extends CollectionAdapter<Set<E>, E> {
    public SetAdapter(Class<E> componentType) {
        super(componentType);
    }

    protected Set<E> createCollectionInstance() {
        return new HashSet<E>();
    }

    public Set<E> _read(Object value, Context context) {
        return unmarshalCollection(value, context);
    }

    public String toString() {
        StringBuilder buff = new StringBuilder();
        buff.append("Adapter(Set<");
        //TODO: check for arrays
        buff.append(containedType.getSimpleName());
        buff.append(">)");

        return buff.toString();
    }
}
