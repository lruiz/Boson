package org.tautua.boson.json.core;

import junit.framework.TestCase;
import org.tautua.foo.Person;
import org.tautua.boson.json.Context;
import org.tautua.boson.json.TypeAdapter;

import java.io.IOException;
import java.io.Writer;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 8, 2008
 * Time: 3:13:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class ContextTest extends TestCase {

      public void testRegisterCustomAdapters() {
        ContextFactoryImpl factory = new ContextFactoryImpl();
        MyTypeAdapter ata = new MyTypeAdapter();
        factory.addComponent(ata);
        Context context = factory.create();
        TypeAdapter ta;

        ta = context.findAdapter(Person.class);
        assertEquals(ata, ta);
    }

    class MyTypeAdapter extends TypeAdapterRegistryImpl.Component implements TypeAdapter {
        public void register(TypeAdapterRegistryImpl context) {
            context.register(Person.class, this);
        }

        public Object read(Object value, Context context) {
            return null;
        }

        public void write(Object o, Writer writer, Context context) throws IOException {
            throw new UnsupportedOperationException();
        }
    }
}
