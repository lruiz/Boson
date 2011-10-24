package org.tautua.boson.json.core.adapters;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 12, 2008
 * Time: 10:32:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class UnknownTypeAdapterTest {/*extends AbstractAdapterTest {
    UnknownTypeAdapter adapter = new UnknownTypeAdapter();
    public void testUnmarshal() throws JSONException {

        JSONObject jobj = new JSONObject("{\"firstName\":\"John\"}");
        Object result = adapter.coerce(jobj, context);
        assertTrue(result instanceof Map);

        result = adapter.coerce(1L, context);
        assertTrue(result instanceof Long);

        JSONArray jarr = new JSONArray("[\"firstName\",\"John\"]");
        result = adapter.coerce(jarr, context);
        assertTrue(result instanceof List);
    }

    public void testToString(){
        assertEquals("Adapter(?)", adapter.toString());
    }
    */
}