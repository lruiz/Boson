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
import org.tautua.boson.json.core.TypeAdapterRegistryImpl;
import org.tautua.boson.json.core.AbstractAdapter;

import java.io.IOException;
import java.io.Writer;

/**
 * @author Larry Ruiz
 */
public abstract class NumberAdapter<T extends Number> extends AbstractAdapter<T> {
    public void _write(T t, Writer writer, Context context) throws IOException {
        writer.append(String.valueOf(t));
    }

    public static class ByteAdapter extends NumberAdapter<Byte> {
        public void register(TypeAdapterRegistryImpl adapterManager) {
            adapterManager.register(Byte.class, this);
            adapterManager.register(byte.class, this);
        }

        public Byte _read(Object value, Context context) {
            return ((Number) value).byteValue();
        }
    }

    public static class ShortAdapter extends NumberAdapter<Short> {
        public void register(TypeAdapterRegistryImpl adapterManager) {
            adapterManager.register(Short.class, this);
            adapterManager.register(short.class, this);
        }

        public Short _read(Object value, Context context) {
            return ((Number) value).shortValue();
        }
    }

    public static class IntegerAdapter extends NumberAdapter<Integer> {
        public void register(TypeAdapterRegistryImpl adapterManager) {
            adapterManager.register(Integer.class, this);
            adapterManager.register(int.class, this);
        }

        public Integer _read(Object value, Context context) {
            return ((Number) value).intValue();
        }
    }

    public static class LongAdapter extends NumberAdapter<Long> {
        public void register(TypeAdapterRegistryImpl adapterManager) {
            adapterManager.register(Long.class, this);
            adapterManager.register(long.class, this);
        }

        public Long _read(Object value, Context context) {
            return ((Number) value).longValue();
        }

    }

    public static class FloatAdapter extends NumberAdapter<Float> {
        public void register(TypeAdapterRegistryImpl adapterManager) {
            adapterManager.register(Float.class, this);
            adapterManager.register(float.class, this);
        }

        public Float _read(Object value, Context context) {
            return ((Number) value).floatValue();
        }
    }

    public static class DoubleAdapter extends NumberAdapter<Double> {
        public void register(TypeAdapterRegistryImpl adapterManager) {
            adapterManager.register(Double.class, this);
            adapterManager.register(double.class, this);
            adapterManager.register(Number.class, this);
        }

        public Double _read(Object value, Context context) {
            return ((Number) value).doubleValue();
        }
    }


}
