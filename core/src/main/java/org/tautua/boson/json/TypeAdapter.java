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

package org.tautua.boson.json;

import java.io.IOException;
import java.io.Writer;

/**
 * <p>An adapter is the basic unit that performs the transformation.</p>
 *
 * @author Larry Ruiz
 */
public interface TypeAdapter<T> {
    /**
     * <p>deserialize the json type to a java object.</p>
     *
     * @param value   The value to deserialize.
     * @param context The context.
     * @return The converted value.
     */
    T read(Object value, Context context);

    /**
     * <p>serialize the java object to json string representation.</p>
     *
     * @param t       The value to serialize.
     * @param writer  The ouput target.
     * @param context The context.
     */
    void write(T t, Writer writer, Context context) throws IOException;
}
