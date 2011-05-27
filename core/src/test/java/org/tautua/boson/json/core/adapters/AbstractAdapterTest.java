package org.tautua.boson.json.core.adapters;

import junit.framework.TestCase;
import static org.tautua.boson.utils.Exceptions.rethrow;
import org.tautua.boson.json.Context;
import org.tautua.boson.json.ContextFactory;
import org.tautua.boson.json.TypeAdapter;
import org.tautua.boson.json.core.ContextFactoryImpl;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 12, 2008
 * Time: 10:25:49 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractAdapterTest extends TestCase {
    protected Context context;
    protected ContextFactory factory;
    private StringWriter output;

    protected StringWriter getOutput() {
        if (output == null)
            output = new StringWriter();

        return output;
    }

    protected void tearDown() throws Exception {
        output = null;
    }

    protected void setUp() throws Exception {
        factory = new ContextFactoryImpl();
        context = factory.create();
    }

    protected <T> T unmarshal(TypeAdapter<T> adapter, Object fromJsonObject) {
        return adapter.read(fromJsonObject, context);
    }

    protected <T> void unmarshalAndAssert(TypeAdapter<T> adapter, Object fromJsonObject, T expected) {
        T result = unmarshal(adapter, fromJsonObject);
        assertEquals(expected, result);
    }

    protected <T> void marshalAndAssert(TypeAdapter<T> adapter, T fromJavaObject, String expected) {
        StringWriter w = new StringWriter();
        try {
            adapter.write(fromJavaObject, w, context);
            assertEquals(expected, w.toString());
        } catch (IOException e) {
            rethrow(e);
        }
    }
}
