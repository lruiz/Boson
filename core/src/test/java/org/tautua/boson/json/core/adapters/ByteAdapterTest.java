package org.tautua.boson.json.core.adapters;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 13, 2008
 * Time: 12:21:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class ByteAdapterTest extends AbstractAdapterTest {

    public void testMarshal() {
        marshalAndAssert(new NumberAdapter.ByteAdapter(), (byte)5, "5");
    }    

    public void testUnmarshal() {
        unmarshalAndAssert(new NumberAdapter.ByteAdapter(), new Integer(5), (byte)5);
        unmarshalAndAssert(new NumberAdapter.ByteAdapter(), new Long(10), (byte)10);
    }

}
