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
import org.tautua.boson.json.core.AbstractAdapter;

import java.io.IOException;
import java.io.Writer;

/**
 * @author Larry Ruiz
 */
public class EnumAdapter<T extends Enum<T>> extends AbstractAdapter<T> {
    private Class<T> enumType;

    public EnumAdapter(Class<T> enumType) {
        this.enumType = enumType;
    }

    public T _read(Object value, Context context) {
        String name = (String) value;
        return Enum.valueOf(enumType, name);
    }

    public void _write(T t, Writer writer, Context context) throws IOException {
        writer.append("\"").append(t.name()).append("\"");
    }
}
