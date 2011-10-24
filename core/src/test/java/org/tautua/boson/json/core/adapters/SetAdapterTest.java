package org.tautua.boson.json.core.adapters;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 13, 2008
 * Time: 12:21:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class SetAdapterTest { /*extends AbstractAdapterTest {
    SetAdapterFactory af = new SetAdapterFactory();
    public void testMarshal() throws IOException {
        Set<Long> set = new HashSet<Long>();
        set.add(1L);
        set.add(2L);
        set.add(3L);
        set.add(4L);
        write(new SetAdapter<Long>(Long.class), set, "[1,2,3,4]");
    }

    public void testUnmarshal() throws JSONException {
        JSONArray json = new JSONArray("[12,23,34,45]");
        Set<Long> result = (Set<Long>) unmarshal(af.create(Long.class), json);
        assertTrue("unexpected size", result.size() == 4);
        assertTrue(result.contains(12L));
        assertTrue(result.contains(34L));
        assertTrue(result.contains(45L));
        assertTrue(result.contains(23L));
    }

    public void testUnmarshalNullElement() throws JSONException {
        JSONArray json = new JSONArray("[1,null,3,4]");
        Set<Long> result = (Set<Long>) unmarshal(af.create(Long.class), json);
        assertTrue("unexpected size", result.size() == 4);
        assertTrue("should contain NULL",result.contains(null));
    }

    public void testToString() {
        assertEquals("Adapter(Set<Long>)", af.create(Long.class).toString());
    }
    */
}