package org.tautua.boson.json.core.adapters;

import org.tautua.boson.json.core.LiteralAdapter;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 12, 2008
 * Time: 10:41:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class CharacterAdapterTest extends AbstractAdapterTest {

    @Override
    public LiteralAdapter getAdapter() {
        return new  CharacterAdapter();
    }

    @Override
    public Object[][] getReadParams() {
        return new Object[][]{
            {"h", 'h'},
        };
    }

    @Override
    public Object[][] getWriteParams() {
        return new Object[][]{
            { 'a', "\"a\""},
        };
    }
}
