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

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import static org.tautua.boson.utils.Exceptions.rethrow;
import org.tautua.boson.json.Context;
import org.tautua.boson.json.TypeAdapter;
import org.tautua.boson.json.Unmarshaller;

import java.io.Reader;
import java.io.StringReader;

/**
 * @author Larry Ruiz
 */
@Deprecated
public class UnmarshallerImpl<T> implements Unmarshaller<T> {
    private Class<T> rootType;

    public UnmarshallerImpl(Class<T> rootType) {
        this.rootType = rootType;
    }

    public T unmarshal(String string, Context context) {
        return unmarshal(new StringReader(string), context);
    }

    public T unmarshal(Reader reader, Context context) {
        T t = null;
        try {
            JSONObject jobj = new JSONObject(new JSONTokener(reader));
            TypeAdapter<T> c = context.findAdapter(rootType);
            t = c.read(jobj, context);
        } catch (JSONException e) {
            rethrow(e);
        }
        return t;
    }
}
