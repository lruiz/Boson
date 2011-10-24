package org.tautua.boson;

import org.tautua.boson.json.ast.*;
import org.tautua.boson.json.util.DequeStack;
import org.tautua.boson.json.util.Stack;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: lruiz
 * Date: 9/23/11
 * Time: 12:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class Transformer<T> implements Visitor {
    
    private Coercion coercion;
    private Stack introspectionStack = new DequeStack();
    private Stack valueStack = new DequeStack();

    public Transformer(Class<T> expectedType) {
        introspectionStack.push(expectedType);
        coercion = new Coercion();
    }
    
    public T get() {
        return (T) valueStack.peek();
    }

    @Override
    public void visit(Literal node) {
        Class expectedType;
        if(introspectionStack.peek() instanceof Field) {
            Field field = (Field) introspectionStack.peek();
            expectedType = field.getType();
        } else {
            expectedType = (Class) introspectionStack.peek();
        }
        
        Object val = coercion.coerce(expectedType, node.getValue());
        valueStack.push(val);
    }

    @Override
    public void visit(Instance node) {
        Class expectedType = (Class) introspectionStack.peek();
        Object object =  Introspection.newInstance(expectedType);
        valueStack.push(object);
        childrenAccept(node);
    }

    @Override
    public void visit(Member node) {
        Object instance = valueStack.peek();
        Field field = Introspection.getFieldByName(instance, node.getName());
        introspectionStack.push(field);
        childrenAccept(node);
        introspectionStack.pop();
        Introspection.setFieldValue(instance, valueStack.pop(), field);
    }

    @Override
    public void visit(Array node) {
        Type containedType = Object.class;
        Class containerType = null;
        
        if(introspectionStack.peek() instanceof Field) {
            Field field = (Field) introspectionStack.peek();
            containedType = Introspection.getCointainedType(field);
            containerType = field.getType(); 
        }
        
        introspectionStack.push(containedType);
        int count = node.jjtGetNumChildren();
        List elements = new ArrayList(count);
        for(int i = 0; i < count; i++) {
            node.jjtGetChild(i).accept(this);
            Object element = valueStack.pop();
            elements.add(element);
        }
        introspectionStack.pop();
        
        Object container = coercion.coerce(containerType, elements);
        valueStack.push(container);
    }
    
    private void childrenAccept(Node parent) {
        int count = parent.jjtGetNumChildren();
        for(int i = 0; i < count; i++) {
            parent.jjtGetChild(i).accept(this);
        }
    }
}
