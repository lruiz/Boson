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

import org.json.JSONObject;

import java.io.Writer;
import java.io.IOException;

/**
 * @author Larry Ruiz
 */
public abstract class LiteralAdapter<T> extends TypeAdapterRegistryImpl.Component {

    public T coerce(Object value) {
        if (value == null || value == JSONObject.NULL) {
            return null;
        }
        return _read(value);
    }

    public void write(T t, Writer writer) throws IOException {
        if (t == null) {
            writer.append("null");
        } else {
            _write(t, writer);
        }
    }

    /**
     * Null safe coerce
     *
     * @param object
     * @return
     */
    protected abstract T _read(Object object);

    /**
     * Null safe write
     *
     * @param t
     * @param writer
     * @throws IOException
     */
    protected abstract void _write(T t, Writer writer) throws IOException;
}
