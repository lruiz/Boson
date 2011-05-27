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
import static org.tautua.boson.utils.Exceptions.rethrow;
import org.tautua.boson.json.Context;
import org.tautua.boson.json.TypeAdapter;
import org.tautua.boson.json.core.AbstractAdapter;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Larry Ruiz
 */
public class BeanAdapter<T> extends AbstractAdapter<T> {
    private Class<T> type;

    public BeanAdapter(Class<T> type) {
        this.type = type;
    }

    public T _read(Object value, Context context) {
        JSONObject jsonObject = (JSONObject) value;
        T current = createInstance(context, jsonObject);
        context.getStack().push(current);

        Class currentType = current.getClass();

        Iterator it = jsonObject.keys();
        while (it.hasNext()) {
            String fieldName = (String) it.next();
            Field field = findField(currentType, fieldName);
            Object jsonValue = null;
            try {
                jsonValue = jsonObject.get(fieldName);
            } catch (JSONException e) {
                rethrow(e);
            }
            if (jsonValue != null) {
                TypeAdapter m = context.findAdapter(field);
                set(current, m.read(jsonValue, context), field);
            }
        }

        context.getStack().pop();
        return current;
    }

    protected T createInstance(Context context, JSONObject jsonObject) {
        T current = null;
        try {
            Constructor<T> constructor = type.getDeclaredConstructor();
            constructor.setAccessible(true);
            current = constructor.newInstance();
        } catch (Exception e) {
            rethrow(e);
        }
        return current;
    }

    private void set(Object target, Object value, Field field) {
        try {
            field.setAccessible(true);
            field.set(target, value);
        } catch (IllegalAccessException e) {
            rethrow(e);
        }
    }

    private Field findField(Class type, String fieldName) {
        try {
            return type.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            rethrow(e);
        }
        return null;
    }

    public void _write(T t, Writer writer, Context context) throws IOException {
        context.getStack().push(t);
        writer.append("{");

        Iterator<Field> itr = retrieve(t, context).iterator();
        while (itr.hasNext()) {
            Field f = itr.next();

            //TODO:applied fecth, escaping, null TypeAdapter
            writer.append("\"").append(f.getName()).append("\":");
            Object val = null;

            try {
                val = f.get(t);
            } catch (IllegalAccessException e) {
                rethrow(e);
            }

            if (val == null) {
                writer.append("null");
            } else {
                TypeAdapter typeAdapter = context.findAdapter(f);
                typeAdapter.write(val, writer, context);
            }

            if (itr.hasNext()) {
                writer.append(",");
            }
        }
        writer.append("}");
        context.getStack().pop();
    }

    protected List<Field> retrieve(T t, Context context) {
        Field[] fields = t.getClass().getDeclaredFields();
        AccessibleObject.setAccessible(fields, true);
        List<Field> result = new ArrayList<Field>();

        for (Field f : fields) {
            if (context.getFetchPlan().fetchable(f, context)) {
                result.add(f);
            }
        }
        return result;
    }

    public String toString() {
        StringBuilder buff = new StringBuilder();
        buff.append("Adapter(").append(type.getSimpleName());
        buff.append(")");
        return buff.toString();
    }
}
