package org.tautua.boson.json.core.adapters;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;

public class ArrayAdapterTest extends AbstractAdapterTest {
    public void testMarshal() throws IOException {
        ArrayAdapterFactory adapterFactory = new ArrayAdapterFactory();
        ArrayAdapter<Number> adapter = adapterFactory.create(Number.class);
        Number[] arr = {1d, 2d, 3d, 4d};
        marshalAndAssert(adapter, arr, "[1.0,2.0,3.0,4.0]");
    }

    public void testMarshalStringArray() throws IOException {
        ArrayAdapterFactory adapterFactory = new ArrayAdapterFactory();
        ArrayAdapter<String> adapter = adapterFactory.create(String.class);
        String[] arr = {"a", "ab", "abc"};
        marshalAndAssert(adapter, arr, "[\"a\",\"ab\",\"abc\"]");
    }

    public void testUnmarshal() throws JSONException {
        ArrayAdapterFactory adapterFactory = new ArrayAdapterFactory();
        JSONArray arr = new JSONArray("[1,2,3,4]");

        Number[] result1 = (Number[]) unmarshal(adapterFactory.create(Number.class), arr);
        assertTrue(result1.length == 4);
        assertTrue("default number type has to be Double", result1[0] instanceof Double);

        Long[] result2 = (Long[]) unmarshal(adapterFactory.create(Long.class), arr);
        assertTrue(result2.length == 4);

        Float[] result3 = (Float[]) unmarshal(adapterFactory.create(Float.class), arr);
        assertTrue(result3.length == 4);
    }

    public void testUnmarshalStringArray() throws JSONException {
        ArrayAdapterFactory adapterFactory = new ArrayAdapterFactory();
        ArrayAdapter<String> adapter = adapterFactory.create(String.class);
        JSONArray arr = new JSONArray("[\"a\",\"ab\",\"abc\"]");
        String[] result = adapter.read(arr, context);
        assertTrue(result.length == 3);
    }
}