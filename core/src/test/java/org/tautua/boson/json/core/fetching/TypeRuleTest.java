package org.tautua.boson.json.core.fetching;

import junit.framework.TestCase;
import org.tautua.foo.Person;
import org.tautua.foo.Task;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 13, 2008
 * Time: 6:46:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class TypeRuleTest extends TestCase {
    private Class type = Person.class;

    public void testDecide() throws NoSuchFieldException {
        FetchRule rule;

        //includes
        rule = new TypeRule(Task.class,true);
        assertEquals(FetchRule.Decision.NOT_APPLY, rule.decide(type.getDeclaredField("firstName"), null));
        assertEquals(FetchRule.Decision.NOT_APPLY, rule.decide(type.getDeclaredField("lastName"), null));
        assertEquals(FetchRule.Decision.FETCH, rule.decide(type.getDeclaredField("currentTask"), null));

        //excludes
        rule = new TypeRule(Task.class,false);
        assertEquals(FetchRule.Decision.NOT_APPLY, rule.decide(type.getDeclaredField("firstName"), null));
        assertEquals(FetchRule.Decision.NOT_APPLY, rule.decide(type.getDeclaredField("lastName"), null));
        assertEquals(FetchRule.Decision.SKIP, rule.decide(type.getDeclaredField("currentTask"), null));
    }
}
