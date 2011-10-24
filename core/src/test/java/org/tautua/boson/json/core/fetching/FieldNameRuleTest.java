package org.tautua.boson.json.core.fetching;

import junit.framework.TestCase;
import org.tautua.foo.Person;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 13, 2008
 * Time: 6:37:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class FieldNameRuleTest extends TestCase {
    private Class type = Person.class;

    public void testDecide() throws NoSuchFieldException {
        FieldNameRule rule;

        //includes
        rule = new FieldNameRule("lastName",true);
        assertEquals(FetchRule.Decision.NOT_APPLY, rule.decide(type.getDeclaredField("firstName")));
        assertEquals(FetchRule.Decision.FETCH, rule.decide(type.getDeclaredField("lastName")));

        //excludes
        rule = new FieldNameRule("lastName",false);
        assertEquals(FetchRule.Decision.NOT_APPLY, rule.decide(type.getDeclaredField("firstName")));
        assertEquals(FetchRule.Decision.SKIP, rule.decide(type.getDeclaredField("lastName")));
    }
}
