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

import org.json.JSONArray;
import org.json.JSONObject;
import org.tautua.boson.json.Context;
import org.tautua.boson.json.TypeAdapter;
import org.tautua.boson.json.core.TypeAdapterRegistryImpl;
import org.tautua.boson.json.core.AbstractAdapter;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

/**
 * @author Larry Ruiz
 */
public class UnknownTypeAdapter extends AbstractAdapter {

    public void register(TypeAdapterRegistryImpl adapterManager) {
        adapterManager.register(Object.class, this);
    }

    public Object _read(Object value, Context context) {
        TypeAdapter ta;
        if (value instanceof JSONObject) {
            ta = context.findAdapter(Map.class);
        } else if (value instanceof JSONArray) {
            ta = context.findAdapter(List.class);
        } else {
            ta = context.findAdapter(value.getClass());
        }
        return ta.read(value, context);
    }

    public void _write(Object o, Writer writer, Context context) throws IOException {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return "Adapter(?)";
    }
}
