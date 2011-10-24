package org.tautua.boson;

import org.junit.Test;
import org.tautua.foo.Person;

import java.lang.reflect.Field;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: lruiz
 * Date: 10/19/11
 * Time: 9:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class IntrospectionTest {
    
    @Test
    public void newInstance() {
        Person p = Introspection.newInstance(Person.class);
        assertThat(p, notNullValue());
    }
    
    @Test
    public void getStringMemberInfo() {
        Person p = new Person("John", "Doe");
        Field f = Introspection.getFieldByName(p, "firstName");
        
        assertThat(f, notNullValue());
    }
}
