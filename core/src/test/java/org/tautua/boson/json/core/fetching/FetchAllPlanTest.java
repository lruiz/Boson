package org.tautua.boson.json.core.fetching;

import junit.framework.TestCase;
import org.tautua.foo.Person;
import org.tautua.boson.json.FetchPlan;

public class FetchAllPlanTest extends TestCase {

    public void testFetchable() throws NoSuchFieldException {
        Class c = Person.class;
        FetchPlan fp = new FetchAllPlan();
        assertTrue(fp.fetchable(c.getDeclaredField("firstName")));
        assertTrue(fp.fetchable(c.getDeclaredField("age")));
        assertTrue(fp.fetchable(c.getDeclaredField("status")));
        assertTrue(fp.fetchable(c.getDeclaredField("currentTask")));
        assertTrue(fp.fetchable(c.getDeclaredField("tasksQueue")));
    }
}
