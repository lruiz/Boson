package org.tautua.boson.json.core;

import junit.framework.TestCase;
import org.tautua.foo.Person;
import org.tautua.boson.json.Context;
import org.tautua.boson.json.ContextFactory;
import org.tautua.boson.json.Unmarshaller;
import org.tautua.boson.json.UnmarshallerFactory;

import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 10, 2008
 * Time: 9:33:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class UnmarshallerTest extends TestCase {
    UnmarshallerFactory umf;
    ContextFactory cf;

    protected void setUp() throws Exception {
        umf = new UnmarshallerFactoryImpl();
        cf = new ContextFactoryImpl();
    }


    public void testUnmarshaller() {
        Reader r = new InputStreamReader(getClass().getResourceAsStream("/person.json"));
        Context ctx = cf.create();
        Unmarshaller<Person> um = umf.create(Person.class);
        Person p = um.unmarshal(r,ctx);
        assertNotNull(p);
        assertEquals("John", p.getFirstName());
        assertEquals("Doe", p.getLastName());
        assertEquals(15, p.getAge());

        p = um.unmarshal("{\"firstName\":\"John\", \"age\":30}",ctx);
        assertEquals(30, p.getAge());        
    }
}
