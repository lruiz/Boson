package org.tautua.boson;

import java.lang.reflect.*;

/**
 * Created by IntelliJ IDEA.
 * User: lruiz
 * Date: 9/23/11
 * Time: 2:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Introspection {
    
    public static <T> T newInstance(Class<T> type) {
        try {
            Constructor constructor = type.getConstructor();
            return (T) constructor.newInstance();
        } catch (Exception e) {
            throw new BosonException(e);
        }
    }

    public static Field getFieldByName(Class clazz, String fieldName) {
        Field field = null;
        do {
            try {
                field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                if(field != null) {
                    return field;
                }
            } catch (NoSuchFieldException e) {
                
            }
            clazz = clazz.getSuperclass();
        } while (!Object.class.equals(clazz));
        
        throw new BosonException("No such field");
    }
    
    public static Field getFieldByName(Object instance, String fieldName) {
        return getFieldByName(instance.getClass(), fieldName);
    }
    
    public static void setFieldValue(Object instance, Object val, Field field) {
        try {
            field.set(instance,val);
        } catch (IllegalAccessException e) {
            throw new BosonException(e);
        }
    }
    
    public static Type getCointainedType(Field field) {
        Class rawType = field.getType();
        if(rawType.isArray()) {
            return rawType.getComponentType();
        }
        
        if (field.getGenericType() instanceof ParameterizedType) {
            Type[] typeArguments = ((ParameterizedType)field.getGenericType()).getActualTypeArguments(); 
            return typeArguments.length == 1 ? typeArguments[0] : null;
        }
        
        throw new IllegalArgumentException("No an array or collection field");
    }

}
