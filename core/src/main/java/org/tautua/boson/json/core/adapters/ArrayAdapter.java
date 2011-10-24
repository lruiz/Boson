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

import org.tautua.boson.json.core.ContainerAdapter;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.List;

/**
 * @author Larry Ruiz
 */
public class ArrayAdapter<E> extends ContainerAdapter<E> {

    public ArrayAdapter(Class<E> containedType) {
        super(containedType);
    }

    public E[] coerce(Object value) {
        Collection<E> collection = (Collection) value;
        E[] arr = (E[]) Array.newInstance(containedType, collection.size());
        return collection.toArray(arr);
    }

    public void write(E[] t, Writer writer) throws IOException {
        writer.append("[");
        writer.append("]");
    }
}
