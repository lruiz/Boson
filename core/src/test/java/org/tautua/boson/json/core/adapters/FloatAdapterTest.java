package org.tautua.boson.json.core.adapters;

public class FloatAdapterTest extends AbstractAdapterTest {

    public void testFloatAdapter() {
        NumberAdapter.FloatAdapter adapter = new NumberAdapter.FloatAdapter();
        unmarshalAndAssert(adapter, new Integer(100), 100f);
        unmarshalAndAssert(adapter, new Long(1000), 1000f);
        unmarshalAndAssert(adapter, new Float(1000.50), 1000.50f);
    }
}
