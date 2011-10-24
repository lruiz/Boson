package org.tautua.boson.json.core.fetching;

import junit.framework.TestCase;
//import static org.mockito.Mockito.*;
import org.tautua.foo.Person;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 13, 2008
 * Time: 7:15:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class MaxDepthRuleTest extends TestCase {
    private Class type = Person.class;

    public void testDecide() throws NoSuchFieldException {
        /*
        FetchRule rule;
        Context ctx = mock(Context.class);
        Stack stack = mock(Stack.class);

        // MAX DEPTH 1
        rule = new MaxDepthRule(1);

        when(ctx.getStack()).thenReturn(stack);
        when(stack.size()).thenReturn(1);

        assertEquals(FetchRule.Decision.FETCH, rule.decide(type.getDeclaredField("firstName"), ctx));
        //verify(ctx, stack);

        reset(ctx, stack);
        when(ctx.getStack()).thenReturn(stack);
        when(stack.size()).thenReturn(1);
        //replay(ctx, stack);
        assertEquals(FetchRule.Decision.FETCH, rule.decide(type.getDeclaredField("status"), ctx));
        //verify(ctx, stack);

        reset(ctx, stack);
        when(ctx.getStack()).thenReturn(stack);
        when(stack.size()).thenReturn(1);
        //replay(ctx, stack);
        assertEquals(FetchRule.Decision.SKIP, rule.decide(type.getDeclaredField("tasksQueue"), ctx));
        //verify(ctx, stack);

        reset(ctx, stack);
        when(ctx.getStack()).thenReturn(stack);
        when(stack.size()).thenReturn(2);
        //replay(ctx, stack);
        assertEquals(FetchRule.Decision.SKIP, rule.decide(type.getDeclaredField("firstName"), ctx));
        //verify(ctx, stack);

        reset(ctx, stack);
        when(ctx.getStack()).thenReturn(stack);
        when(stack.size()).thenReturn(1);
        //replay(ctx, stack);
        assertEquals(FetchRule.Decision.SKIP, rule.decide(type.getDeclaredField("currentTask"), ctx));
        //verify(ctx, stack);


        // MAX DEPTH 2
        rule = new MaxDepthRule(2);

        reset(ctx, stack);
        when(ctx.getStack()).thenReturn(stack);
        when(stack.size()).thenReturn(1);
        //replay(ctx, stack);
        assertEquals(FetchRule.Decision.FETCH, rule.decide(type.getDeclaredField("firstName"), ctx));
        //verify(ctx, stack);

        reset(ctx, stack);
        when(ctx.getStack()).thenReturn(stack);
        when(stack.size()).thenReturn(1);
        //replay(ctx, stack);
        assertEquals(FetchRule.Decision.FETCH, rule.decide(type.getDeclaredField("currentTask"), ctx));
        //verify(ctx, stack);

        reset(ctx, stack);
        when(ctx.getStack()).thenReturn(stack);
        when(stack.size()).thenReturn(1);
        //replay(ctx, stack);
        assertEquals(FetchRule.Decision.FETCH, rule.decide(type.getDeclaredField("tasksQueue"), ctx));
        //verify(ctx, stack);
        */
    }
}
