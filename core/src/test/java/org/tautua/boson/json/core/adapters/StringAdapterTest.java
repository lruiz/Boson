package org.tautua.boson.json.core.adapters;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 12, 2008
 * Time: 10:32:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringAdapterTest extends AbstractAdapterTest {
    StringAdapter adapter = new StringAdapter();
    public void testMarshal() throws IOException {
        marshalAndAssert(adapter, "hello", "\"hello\"");
    }
    
    public void testUnmarshal() {
        unmarshalAndAssert(adapter, "hello", "hello");
    }

    public void testToString() {
        assertEquals("Adapter(String)", adapter.toString());
    }
}
