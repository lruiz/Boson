package org.tautua.boson.json.core.adapters;

import org.tautua.foo.Status;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 12, 2008
 * Time: 10:32:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class EnumAdapterTest extends AbstractAdapterTest {

    public void testMarshal() throws IOException {
        marshalAndAssert(new EnumAdapter(Status.class), Status.OK, "\"OK\"");
    }
    
    public void testUnmarshal() {
        unmarshalAndAssert(new EnumAdapter(Status.class), "OK", Status.OK);
    }
}