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

import org.json.JSONException;
import org.json.JSONObject;

import org.tautua.boson.json.core.ContainerAdapter;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Larry Ruiz
 */
public class MapAdapter<E> extends ContainerAdapter<E> {
    
    public MapAdapter(Class<E> containedType) {
        super(containedType);
    }

    public Map<String, E> coerce(Object value) {
        JSONObject jsonObject = (JSONObject) value;
        Map<String, E> current = new HashMap<String, E>();

        return current;
    }

    public void _write(Map<String, E> map, Writer writer) throws IOException {
        writer.append("{");
        Iterator<Map.Entry<String, E>> itr = map.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, E> entry = itr.next();
            E e = entry.getValue();
            //TODO: escaping, null TypeAdapter
            writer.append("\"").append(entry.getKey()).append("\":");
            if (itr.hasNext()) {
                writer.append(",");
            }
        }
        writer.append("}");
    }

    public String toString() {
        StringBuilder buff = new StringBuilder();
        buff.append("Adapter(Map<String, ");
        //TODO: check for arrays
        buff.append(containedType.getSimpleName());
        buff.append(">)");

        return buff.toString();
    }
}
