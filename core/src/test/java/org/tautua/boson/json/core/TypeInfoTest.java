package org.tautua.boson.json.core;

import junit.framework.TestCase;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class TypeInfoTest extends TestCase {
    static class A<T extends B> {
        private int[] intArray;
        private List<String> stringList;
        private List<Long[]> longArrayList;
        private Map<String, Long[]> stringLongArrayMap;
        private List<T> bList;

        private List list;
    }

    static class B {

    }

    public void testTypeInfo() {
        TypeInfo typeInfo = TypeInfo.describe(A.class);
        assertNotNull(typeInfo);
        assertFalse(typeInfo.isArray());
    }

    public void testDescribeField() throws NoSuchFieldException {
        Field f = A.class.getDeclaredField("intArray");
        TypeInfo typeInfo = TypeInfo.describe(f);
        assertNotNull(typeInfo);
        assertTrue(typeInfo.isArray());
        assertNotNull(typeInfo.getActualTypeAugmentations());
        assertEquals(int.class, typeInfo.getActualTypeAugmentations()[0]);
        System.out.println(typeInfo);

        f = A.class.getDeclaredField("stringList");
        typeInfo = TypeInfo.describe(f);
        assertNotNull(typeInfo);
        assertFalse(typeInfo.isArray());
        assertEquals(List.class, typeInfo.getRawType());
        assertNotNull(typeInfo.getActualTypeAugmentations());
        assertEquals(String.class, typeInfo.getActualTypeAugmentations()[0]);
        System.out.println(typeInfo);

        f = A.class.getDeclaredField("longArrayList");
        typeInfo = TypeInfo.describe(f);
        assertNotNull(typeInfo);
        assertFalse(typeInfo.isArray());
        assertEquals(List.class, typeInfo.getRawType());
        assertNotNull(typeInfo.getActualTypeAugmentations());
        assertEquals(Long[].class, typeInfo.getActualTypeAugmentations()[0]);
        System.out.println(typeInfo);

        f = A.class.getDeclaredField("stringLongArrayMap");
        typeInfo = TypeInfo.describe(f);
        assertNotNull(typeInfo);
        assertFalse(typeInfo.isArray());
        assertEquals(Map.class, typeInfo.getRawType());
        assertNotNull(typeInfo.getActualTypeAugmentations());
        assertEquals(String.class, typeInfo.getActualTypeAugmentations()[0]);
        assertEquals(Long[].class, typeInfo.getActualTypeAugmentations()[1]);
        System.out.println(typeInfo);

        f = A.class.getDeclaredField("bList");
        typeInfo = TypeInfo.describe(f);
        assertNotNull(typeInfo);
        assertFalse(typeInfo.isArray());
        assertEquals(List.class, typeInfo.getRawType());
        assertNotNull(typeInfo.getActualTypeAugmentations());
        System.out.println(typeInfo);

        f = A.class.getDeclaredField("list");
        typeInfo = TypeInfo.describe(f);
        assertNotNull(typeInfo);
        assertFalse(typeInfo.isArray());
        assertEquals(List.class, typeInfo.getRawType());
        assertNotNull(typeInfo.getActualTypeAugmentations());
        System.out.println(typeInfo);
    }
}
