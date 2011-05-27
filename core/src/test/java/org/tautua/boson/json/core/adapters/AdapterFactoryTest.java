package org.tautua.boson.json.core.adapters;

import junit.framework.TestCase;
import org.tautua.foo.Status;
import org.tautua.boson.json.TypeAdapter;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Aug 14, 2008
 * Time: 2:17:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class AdapterFactoryTest extends TestCase {
    public void testEnumAdapterFactory() {
        EnumAdapterFactory f = new EnumAdapterFactory();
        TypeAdapter<Status> a = f.create(Status.class);
        assertNotNull(a);

        try{
            f.create(Object.class);
            fail("should fail");
        } catch(Exception e){
            //do nothing            
        }
    }
}
