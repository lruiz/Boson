package org.tautua.boson;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: lruiz
 * Date: 10/20/11
 * Time: 9:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class CoercionTest {
    Coercion c = new Coercion();
    @Test
    public void convertString() {
        String v = "dummy";
        String r = (String)c.coerce(String.class, v);
        assertThat(r,is(equalTo("dummy")));
    }
    
    @Test
    public void convertInt() {
        Long v = 2L;
        int r = (Integer)c.coerce(Integer.class, v);
        assertThat(r,is(equalTo(2)));
    }

    @Test
    public void convertLong() {
        Long v = 5L;
        long r = (Long)c.coerce(Long.class, v);
        assertThat(r,is(equalTo(5L)));
    }
    
    @Test
    public void convertArray() {
        List l = new ArrayList();
        l.add(1L);
        l.add(2L);
        
        Long[] arr = new Long[0];
        Object r = c.coerce(arr.getClass(), l);
        
        assertThat(r.getClass().isArray(), is(true));
      
    }

    @Test
    public void convertCollection() {
        List l = new ArrayList();
        l.add(1L);
        l.add(2L);
        
        Collection r = (Collection) c.coerce(Collection.class, l);
        assertThat(r.size(), is(2));
    }

    @Test
    public void convertList() {
        List l = new ArrayList();
        l.add(1L);
        l.add(2L);
        
        List r = (List) c.coerce(List.class, l);
        assertThat(r.size(), is(2));    }
    
    @Test
    public void convertSet() {
        List l = new ArrayList();
        l.add(1L);
        l.add(2L);
        
        Set r = (Set) c.coerce(Set.class, l);
        assertThat(r.size(), is(2));
    }
    
}
