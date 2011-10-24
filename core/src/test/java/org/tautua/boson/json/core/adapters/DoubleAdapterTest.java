package org.tautua.boson.json.core.adapters;

import org.tautua.boson.json.core.LiteralAdapter;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 13, 2008
 * Time: 12:21:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class DoubleAdapterTest extends AbstractAdapterTest {

    @Override
    public LiteralAdapter getAdapter() {
        return new  NumberAdapter.DoubleAdapter();
    }

    @Override
    public Object[][] getReadParams() {
        return new Object[][]{
            {new Long(1000), 1000d},
            {new Float(1000.50), 1000.5d},
        };
    }

    @Override
    public Object[][] getWriteParams() {
        return new Object[][]{
            {100d, "100.0"},
            {100.55d, "100.55"}
        };
    }
}