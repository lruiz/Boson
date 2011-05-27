package org.tautua.boson.json.core;


import org.junit.Test;
import org.tautua.foo.Person;
import org.tautua.boson.json.TypeAdapterRegistry;
import org.tautua.boson.json.TypeAdapter;
import org.tautua.boson.json.core.adapters.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 14, 2008
 * Time: 4:29:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class AdapterManagerTest {

    @Test
    public void testFindDefaultAdapters() {
        TypeAdapterRegistry amng = new TypeAdapterRegistryImpl();
        TypeAdapter ta = amng.findAdapter(String.class);
        assertTrue(ta instanceof StringAdapter);
        ta = amng.findAdapter(Boolean.class);
        assertTrue(ta instanceof BooleanAdapter);
        ta = amng.findAdapter(boolean.class);
        assertTrue(ta instanceof BooleanAdapter);
        ta = amng.findAdapter(Number.class);
        assertTrue(ta instanceof NumberAdapter.DoubleAdapter);
        ta = amng.findAdapter(Byte.class);
        assertTrue(ta instanceof NumberAdapter.ByteAdapter);
        ta = amng.findAdapter(byte.class);
        assertTrue(ta instanceof NumberAdapter.ByteAdapter);
        ta = amng.findAdapter(Short.class);
        assertTrue(ta instanceof NumberAdapter.ShortAdapter);
        ta = amng.findAdapter(short.class);
        assertTrue(ta instanceof NumberAdapter.ShortAdapter);
        ta = amng.findAdapter(Integer.class);
        assertTrue(ta instanceof NumberAdapter.IntegerAdapter);
        ta = amng.findAdapter(int.class);
        assertTrue(ta instanceof NumberAdapter.IntegerAdapter);
        ta = amng.findAdapter(Long.class);
        assertTrue(ta instanceof NumberAdapter.LongAdapter);
        ta = amng.findAdapter(long.class);
        assertTrue(ta instanceof NumberAdapter.LongAdapter);
        ta = amng.findAdapter(Float.class);
        assertTrue(ta instanceof NumberAdapter.FloatAdapter);
        ta = amng.findAdapter(float.class);
        assertTrue(ta instanceof NumberAdapter.FloatAdapter);
        ta = amng.findAdapter(Double.class);
        assertTrue(ta instanceof NumberAdapter.DoubleAdapter);
        ta = amng.findAdapter(double.class);
        assertTrue(ta instanceof NumberAdapter.DoubleAdapter);

        ta = amng.findAdapter(String[].class);
        assertTrue(ta instanceof ArrayAdapter);

        ta = amng.findAdapter(List.class);
        assertEquals(ListAdapter.class, ta.getClass());
        ta = amng.findAdapter(Set.class);
        assertEquals(SetAdapter.class, ta.getClass());
        ta = amng.findAdapter(Map.class);
        assertEquals(MapAdapter.class, ta.getClass());

        ta = amng.findAdapter(Person.class);
        assertEquals(BeanAdapter.class, ta.getClass());
    }
}
