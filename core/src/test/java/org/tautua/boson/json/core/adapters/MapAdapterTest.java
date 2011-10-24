package org.tautua.boson.json.core.adapters;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 12, 2008
 * Time: 10:32:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class MapAdapterTest {/*extends AbstractAdapterTest {
    MapAdapterFactory af = new MapAdapterFactory();
    public void testMarshal() throws IOException {
        Map<String, Long> map = new HashMap<String, Long>();
        map.put("count", 5L);
        map.put("priority", 10L);

        write(af.create(Long.class), map, "{\"count\":5,\"priority\":10}");
    }

    public void testUnmarshalString() throws JSONException {
        JSONObject json =
                new JSONObject("{\"firstName\":\"John\",\"lastName\":\"Doe\"}");
        Map<String, String> expected = new HashMap();
        expected.put("firstName", "John");
        expected.put("lastName", "Doe");

        coerce(af.create(String.class), json, expected);
    }

    public void testUnmarshalLong() throws JSONException {
        JSONObject json = new JSONObject("{\"min\":1,\"max\":10}");
        Map<String, Long> expected = new HashMap();
        expected.put("min", 1L);
        expected.put("max", 10L);

        coerce(af.create(Long.class), json, expected);
    }


    public void testUnmarshalFloatArray() throws JSONException {
        JSONObject json = new JSONObject("{\"set1\":[1,1.50],\"set2\":[10, 5.5]}");
        Map<String, Float[]> r = unmarshal(new MapAdapter<Float[]>(Float[].class), json);
        assertEquals(1f, r.get("set1")[0]);
        assertEquals(1.50f, r.get("set1")[1]);
        assertEquals(10f, r.get("set2")[0]);
        assertEquals(5.5f, r.get("set2")[1]);
    }

    public void testUnmarshalUnknowType() throws JSONException {
        JSONObject json = new JSONObject("{\"set1\":[1,1.50],\"set2\":[10, 5.5]}");
        Map<String, Object[]> r = unmarshal(new MapAdapter<Object[]>(Object[].class), json);
        assertEquals(1, r.get("set1")[0]);
        assertEquals(1.50d, r.get("set1")[1]);
        assertEquals(10, r.get("set2")[0]);
        assertEquals(5.5d, r.get("set2")[1]);
    }

    public void testToString() {
        assertEquals("Adapter(Map<String, Long>)", af.create(Long.class).toString());
    }
    */
}