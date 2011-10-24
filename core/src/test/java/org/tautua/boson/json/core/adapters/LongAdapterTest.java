package org.tautua.boson.json.core.adapters;

import org.tautua.boson.json.core.LiteralAdapter;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 13, 2008
 * Time: 12:21:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class LongAdapterTest extends AbstractAdapterTest {

    @Override
    public LiteralAdapter getAdapter() {
        return new NumberAdapter.LongAdapter();
    }

    @Override
    public Object[][] getReadParams() {
        return new Object[][]{
            {new Integer(100), 100L},
            {new Long(1000), 1000L}
        };
    }

    @Override
    public Object[][] getWriteParams() {
        return new Object[][]{
            {100L, "100"}
        };
    }
}