package org.tautua.boson.json.core.adapters;

import org.json.JSONException;
import org.json.JSONObject;
import org.tautua.foo.Person;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 13, 2008
 * Time: 8:44:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class BeanAdapterTest { /*extends AbstractAdapterTest {
    public void testUnmarshal() throws JSONException {
        JSONObject json = new JSONObject("{\"firstName\":\"Larry\",\"roles\":[\"ADMIN\",\"ANALYST\"]}");
        Person p = unmarshal(new BeanAdapter<Person>(Person.class), json);

        assertEquals("Larry", p.getFirstName());
        assertTrue(p.getRoles().size() == 2);
        assertEquals("ADMIN", p.getRoles().get(0));
        assertEquals("ANALYST", p.getRoles().get(1));
    }

    public void testUnmarshalNoSuchField() throws JSONException {
        JSONObject json = new JSONObject("{\"firstName\":\"Larry\",\"groups\":[\"ADMIN\",\"ANALYST\"]}");
        try{
            unmarshal(new BeanAdapter<Person>(Person.class), json);
            fail("should fail");
        }catch(Exception e) {
            //do nothing
        }
    }

    public void testMarshal() throws JSONException {
        Person p = new Person("John", "Doe");
        p.addRole("ADMIN");
        p.setAge(15);
        write(new BeanAdapter<Person>(Person.class), p, "{\"lastName\":\"Doe\",\"firstName\":\"John\",\"age\":15,\"roles\":[\"ADMIN\"],\"currentTask\":null,\"tasksQueue\":null,\"status\":\"OK\"}");
    }

    public void testToString(){
        assertEquals("Adapter(Person)", new BeanAdapter(Person.class).toString());
    }
    */
}
