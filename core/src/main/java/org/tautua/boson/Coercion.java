package org.tautua.boson;


import org.tautua.boson.json.TypeAdapterRegistry;
import org.tautua.boson.json.core.ContainerAdapter;
import org.tautua.boson.json.core.LiteralAdapter;
import org.tautua.boson.json.core.TypeAdapterRegistryImpl;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: lruiz
 * Date: 10/19/11
 * Time: 11:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Coercion {
    TypeAdapterRegistry r = new TypeAdapterRegistryImpl();
    
    public Object coerce(Class<?> expectedType, Object literal) {
        LiteralAdapter adapter = r.findLiteralAdapter(expectedType);
        return adapter.coerce(literal);
    }
    
    public Object coerce(Class<?> expectedType, List elements) {
        ContainerAdapter adapter = r.findContainerAdapter(expectedType);
        return adapter.coerce(elements);
    }
}
