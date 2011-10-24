package org.tautua.boson.json.core.adapters;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.tautua.boson.json.core.LiteralAdapter;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 12, 2008
 * Time: 10:25:49 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractAdapterTest {
   
    public abstract LiteralAdapter getAdapter();
    
    public abstract Object[][] getReadParams();

    public abstract Object[][] getWriteParams();
    

    protected <T> void read(LiteralAdapter<T> adapter, Object val, T expected) {
        T result = adapter.coerce(val);
        assertThat("coerce fail",result, equalTo(expected));
    }

    protected <T> void write(LiteralAdapter<T> adapter, T val, String expected) {
        StringWriter w = new StringWriter();
        try {
            adapter.write(val, w);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertThat("write fail", w.toString(), equalTo(expected));

    }

    

    @Test
    public void execute() {
        LiteralAdapter adapter = getAdapter();
        Object[][] rparams = getReadParams();
        Object[][] wparams = getWriteParams();
        
        for(int i = 0; i < rparams.length; i++) {
            read(adapter, rparams[i][0], rparams[i][1]);
        }

        for(int i = 0; i < wparams.length; i++) {
            write(adapter, wparams[i][0], (String) wparams[i][1]);
        }

    }
}
