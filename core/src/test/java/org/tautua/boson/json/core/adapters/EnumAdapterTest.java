package org.tautua.boson.json.core.adapters;

import org.tautua.boson.json.core.LiteralAdapter;
import org.tautua.foo.Status;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 12, 2008
 * Time: 10:32:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class EnumAdapterTest extends AbstractAdapterTest {
    @Override
    public LiteralAdapter getAdapter() {
        return new EnumAdapter(Status.class);
    }

    @Override
    public Object[][] getReadParams() {
        return new Object[][]{
                {"OK", Status.OK}
        };
    }

    @Override
    public Object[][] getWriteParams() {
        return new Object[][]{
                {Status.OK, "\"OK\""}
        };
    }
}