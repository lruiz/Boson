package org.tautua.boson.json.core.adapters;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 13, 2008
 * Time: 12:21:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class DoubleAdapterTest extends AbstractAdapterTest {

    public void testMarshal() {
        marshalAndAssert(new NumberAdapter.DoubleAdapter(), 100.55d, "100.55");
    }

    public void testUnmarshal() {
        unmarshalAndAssert(new NumberAdapter.DoubleAdapter(), new Long(1000), 1000d);
        unmarshalAndAssert(new NumberAdapter.DoubleAdapter(), new Float(1000.50), 1000.5d);
    }
}