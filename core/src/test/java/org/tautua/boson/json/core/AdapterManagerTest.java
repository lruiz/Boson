package org.tautua.boson.json.core;


import org.junit.Test;
import org.tautua.boson.json.TypeAdapterRegistry;
import org.tautua.boson.json.core.adapters.*;

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
        LiteralAdapter ta = amng.findLiteralAdapter(String.class);
        assertTrue(ta instanceof StringAdapter);
        ta = amng.findLiteralAdapter(Boolean.class);
        assertTrue(ta instanceof BooleanAdapter);
        ta = amng.findLiteralAdapter(boolean.class);
        assertTrue(ta instanceof BooleanAdapter);
        ta = amng.findLiteralAdapter(Number.class);
        assertTrue(ta instanceof NumberAdapter.DoubleAdapter);
        ta = amng.findLiteralAdapter(Byte.class);
        assertTrue(ta instanceof NumberAdapter.ByteAdapter);
        ta = amng.findLiteralAdapter(byte.class);
        assertTrue(ta instanceof NumberAdapter.ByteAdapter);
        ta = amng.findLiteralAdapter(Short.class);
        assertTrue(ta instanceof NumberAdapter.ShortAdapter);
        ta = amng.findLiteralAdapter(short.class);
        assertTrue(ta instanceof NumberAdapter.ShortAdapter);
        ta = amng.findLiteralAdapter(Integer.class);
        assertTrue(ta instanceof NumberAdapter.IntegerAdapter);
        ta = amng.findLiteralAdapter(int.class);
        assertTrue(ta instanceof NumberAdapter.IntegerAdapter);
        ta = amng.findLiteralAdapter(Long.class);
        assertTrue(ta instanceof NumberAdapter.LongAdapter);
        ta = amng.findLiteralAdapter(long.class);
        assertTrue(ta instanceof NumberAdapter.LongAdapter);
        ta = amng.findLiteralAdapter(Float.class);
        assertTrue(ta instanceof NumberAdapter.FloatAdapter);
        ta = amng.findLiteralAdapter(float.class);
        assertTrue(ta instanceof NumberAdapter.FloatAdapter);
        ta = amng.findLiteralAdapter(Double.class);
        assertTrue(ta instanceof NumberAdapter.DoubleAdapter);
        ta = amng.findLiteralAdapter(double.class);
        assertTrue(ta instanceof NumberAdapter.DoubleAdapter);
    }
}
