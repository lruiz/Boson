package org.tautua.boson.json.core.adapters;

import org.tautua.boson.json.core.LiteralAdapter;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 12, 2008
 * Time: 10:32:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringAdapterTest extends AbstractAdapterTest {
    @Override
    public LiteralAdapter getAdapter() {
        return new StringAdapter();
    }

    @Override
    public Object[][] getReadParams() {
        return new Object[][]{
            {"hello", "hello"}
        };
    }

    @Override
    public Object[][] getWriteParams() {
        return new Object[][]{
            {"hello", "\"hello\""}
        };
    }
}
