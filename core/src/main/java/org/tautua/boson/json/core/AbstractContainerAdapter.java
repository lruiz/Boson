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

import org.tautua.boson.json.Context;
import org.tautua.boson.json.TypeAdapter;

import java.io.IOException;
import java.io.Writer;

/**
 * @author Larry Ruiz
 */
public abstract class AbstractContainerAdapter<T, E> extends AbstractAdapter<T>
        implements ContainerAdapter<T, E> {

    protected Class<E> containedType;

    public Class<E> getContainedType() {
        return containedType;
    }

    protected E unmarshalElement(Object value, Context context) {
        TypeAdapter<E> typeAdapter = context.findAdapter(containedType);
        return typeAdapter.read(value, context);
    }

    protected void marshalElement(E e, Writer writer, Context context) throws IOException {
        TypeAdapter<E> typeAdapter = context.findAdapter(containedType);
        typeAdapter.write(e, writer, context);
    }
}
