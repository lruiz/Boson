package org.tautua.boson.json.core.adapters;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 13, 2008
 * Time: 12:21:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class IntegerAdapterTest extends AbstractAdapterTest {

    public void testUnmarshal() {
        NumberAdapter.IntegerAdapter adapter = new NumberAdapter.IntegerAdapter();
        unmarshalAndAssert(adapter, new Integer(100), 100);
        unmarshalAndAssert(adapter, new Long(1000), 1000);
    }
}