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

import static org.tautua.boson.utils.Exceptions.rethrow;
import org.tautua.boson.json.Context;
import org.tautua.boson.json.Marshaller;
import org.tautua.boson.json.TypeAdapter;

import java.io.IOException;
import java.io.Writer;

/**
 * @author Larry Ruiz
 */
@Deprecated
public class MarshallerImpl<T> implements Marshaller<T> {
    private Class<T> rootType;

    public MarshallerImpl(Class<T> rootType) {
        this.rootType = rootType;
    }

    public void marshal(T t, Writer writer, Context context) {
        TypeAdapter<T> typeAdpater = context.findAdapter(rootType);
        try {
            typeAdpater.write(t, writer, context);
        } catch (IOException e) {
            rethrow(e);
        }
    }
}
