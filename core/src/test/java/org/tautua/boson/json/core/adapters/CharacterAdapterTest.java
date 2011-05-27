package org.tautua.boson.json.core.adapters;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 12, 2008
 * Time: 10:41:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class CharacterAdapterTest extends AbstractAdapterTest {
    public void testMarshal() throws IOException {
        marshalAndAssert(new CharacterAdapter(), 'a', "\"a\"");
    }

    public void testUnmarshal() {
        unmarshalAndAssert(new CharacterAdapter(), "h", 'h');
    }
}
