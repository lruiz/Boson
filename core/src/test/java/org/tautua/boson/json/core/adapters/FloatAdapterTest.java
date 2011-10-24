package org.tautua.boson.json.core.adapters;

import org.tautua.boson.json.core.LiteralAdapter;

public class FloatAdapterTest extends AbstractAdapterTest {


    @Override
    public LiteralAdapter getAdapter() {
        return new  NumberAdapter.FloatAdapter();
    }

    @Override
    public Object[][] getReadParams() {
        return new Object[][]{
            {new Integer(100), 100f},
            {new Long(1000), 1000f},
            {new Float(1000.50), 1000.50f}
        };
    }

    @Override
    public Object[][] getWriteParams() {
        return new Object[][]{
            {100f, "100.0"}
        };
    }
}
