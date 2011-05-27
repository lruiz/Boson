package org.tautua.boson.json.core.fetching;

import junit.framework.TestCase;
import org.tautua.foo.Person;
import org.tautua.boson.json.FetchPlan;

public class FetchAllPlanTest extends TestCase {

    public void testFetchable() throws NoSuchFieldException {
        Class c = Person.class;
        FetchPlan fp = new FetchAllPlan();
        assertTrue(fp.fetchable(c.getDeclaredField("firstName"), null));
        assertTrue(fp.fetchable(c.getDeclaredField("age"), null));
        assertTrue(fp.fetchable(c.getDeclaredField("status"), null));
        assertTrue(fp.fetchable(c.getDeclaredField("currentTask"), null));
        assertTrue(fp.fetchable(c.getDeclaredField("tasksQueue"), null));
    }
}
