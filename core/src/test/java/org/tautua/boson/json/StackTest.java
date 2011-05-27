package org.tautua.boson.json;

import junit.framework.TestCase;
import org.tautua.boson.json.util.DequeStack;
import org.tautua.boson.json.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 13, 2008
 * Time: 9:00:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class StackTest extends TestCase {

    public void test() {
        Stack s = new DequeStack();
        s.push(1L);
        assertEquals(1L, s.peek());
        assertEquals(1, s.size());
        s.push(2L);
        assertEquals(2L, s.peek());
        assertEquals(2, s.size());
        assertEquals(2L, s.pop());
        assertEquals(1, s.size());
        assertEquals(1L, s.peek());
    }
}
