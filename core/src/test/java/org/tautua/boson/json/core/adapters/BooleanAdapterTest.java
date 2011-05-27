package org.tautua.boson.json.core.adapters;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 12, 2008
 * Time: 11:23:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class BooleanAdapterTest extends AbstractAdapterTest {
    public void testMarshal() throws IOException {
        marshalAndAssert(new BooleanAdapter(), true, "true");
    }

    public void testUnmarshal() {
        unmarshalAndAssert(new BooleanAdapter(), Boolean.TRUE, true);
    }
}
