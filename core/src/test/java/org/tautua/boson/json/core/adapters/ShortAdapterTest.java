package org.tautua.boson.json.core.adapters;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 13, 2008
 * Time: 12:21:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class ShortAdapterTest extends AbstractAdapterTest {

    public void testUnmarshal() {
        unmarshalAndAssert(new NumberAdapter.ShortAdapter(), new Integer(5), (short)5);
        unmarshalAndAssert(new NumberAdapter.ShortAdapter(), new Long(10), (short)10);
    }

}