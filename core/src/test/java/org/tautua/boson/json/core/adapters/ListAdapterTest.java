package org.tautua.boson.json.core.adapters;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 13, 2008
 * Time: 12:21:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class ListAdapterTest {/*} extends AbstractAdapterTest {
    ListAdapterFactory af = new ListAdapterFactory();
    public void testMarshal() throws IOException {
        List<Long> list = new ArrayList<Long>();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(4L);
        write(af.create(Long.class), list, "[1,2,3,4]");
    }

    public void testUnmarshal() throws JSONException {
        JSONArray json = new JSONArray("[1,2,3,4]");
        List<Long> result = (List<Long>) unmarshal(af.create(Long.class), json);
        assertTrue("unexpected size", result.size() == 4);
    }

    public void testUnmarshalNullElement() throws JSONException {
        JSONArray json = new JSONArray("[1,null,3,4]");
        List<Long> result = (List<Long>) unmarshal(af.create(Long.class), json);
        assertNull(result.get(1));
        assertTrue("unexpected size", result.size() == 4);
    }

    public void testMarshalNullElement() throws JSONException {
        List<Long> list = new ArrayList<Long>();
        list.add(1L);
        list.add(null);
        write(af.create(Long.class), list, "[1,null]");
    }

    public void testToString() {
        assertEquals("Adapter(List<Long>)", af.create(Long.class).toString());
    }
    */
}