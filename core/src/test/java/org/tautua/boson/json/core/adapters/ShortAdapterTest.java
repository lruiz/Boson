package org.tautua.boson.json.core.adapters;

import org.tautua.boson.json.core.LiteralAdapter;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 13, 2008
 * Time: 12:21:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class ShortAdapterTest extends AbstractAdapterTest {

    @Override
    public LiteralAdapter getAdapter() {
        return new NumberAdapter.ShortAdapter();
    }

    @Override
    public Object[][] getReadParams() {
        return new Object[][]{
            {new Integer(5), (short) 5}
        };
    }

    @Override
    public Object[][] getWriteParams() {
        return new Object[][]{
            {(short) 5, "5"}
        };
    }
}