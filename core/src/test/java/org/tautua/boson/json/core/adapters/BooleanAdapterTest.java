package org.tautua.boson.json.core.adapters;

import org.tautua.boson.json.core.LiteralAdapter;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 12, 2008
 * Time: 11:23:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class BooleanAdapterTest extends AbstractAdapterTest {

    @Override
    public LiteralAdapter getAdapter() {
        return new BooleanAdapter();
    }

    @Override
    public Object[][] getReadParams() {
        return new Object[][]{
            {Boolean.TRUE, true},
        };
    }

    @Override
    public Object[][] getWriteParams() {
        return new Object[][]{
            {true, "true"},
        };
    }
}
