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
import org.json.JSONException;
import static org.tautua.boson.utils.Exceptions.rethrow;
import org.tautua.boson.json.Context;
import org.tautua.boson.json.core.AbstractContainerAdapter;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Larry Ruiz
 */
public class ArrayAdapter<E> extends AbstractContainerAdapter<E[], E> {

    public ArrayAdapter(Class<E> containedType) {
        this.containedType = containedType;
    }

    public E[] _read(Object value, Context context) {
        JSONArray jsonArray = (JSONArray) value;
        E[] arr = (E[]) Array.newInstance(containedType, jsonArray.length());
        for (int i = 0; i < jsonArray.length(); i++) {
            Object v = null;
            try {
                v = jsonArray.get(i);
            } catch (JSONException e) {
                rethrow(e);
            }

            arr[i] = unmarshalElement(v, context);
        }
        return arr;
    }

    public void _write(E[] t, Writer writer, Context context) throws IOException {
        writer.append("[");
        Iterator<E> itr = Arrays.asList(t).iterator();
        while (itr.hasNext()) {
            E e = itr.next();
            marshalElement(e, writer, context);
            if (itr.hasNext()) {
                writer.append(",");
            }
        }
        writer.append("]");
    }
}
