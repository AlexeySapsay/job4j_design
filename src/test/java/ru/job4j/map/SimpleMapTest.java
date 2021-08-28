package ru.job4j.map;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void testForMainTest() {
        SimpleMap<String, Integer> simpleMap = new SimpleMap<>();
        assertTrue(simpleMap.put("Alex", 10));
    }

    @Test
    public void whenPutThenTrue() {
        SimpleMap<String, Integer> simpleMap = new SimpleMap<>();
        assertTrue(simpleMap.put("Alex", 10));
    }

    @Test
    public void whenPutThenFalse() {
        SimpleMap<String, Integer> simpleMap = new SimpleMap<>();
        assertTrue(simpleMap.put("Alex", 10));
        assertFalse(simpleMap.put("Alex", 10));
    }

    @Test
    public void testMultiplePut() {
        SimpleMap<String, Integer> simpleMap = new SimpleMap<>();
        assertTrue(simpleMap.put("0", 0));
        assertTrue(simpleMap.put("1", 1));
        assertTrue(simpleMap.put("2", 2));
        assertTrue(simpleMap.put("3", 3));
        assertTrue(simpleMap.put("4", 4));
        assertTrue(simpleMap.put("5", 5));
    }


    @Test
    public void testForExpandEncriseCapacityFrom8To32() {
        SimpleMap<String, Integer> simpleMap = new SimpleMap<>();
        assertTrue(simpleMap.put("aaaa", 0));
        assertTrue(simpleMap.put("rrszdf", 1));
        assertTrue(simpleMap.put("ccasd", 2));
        assertTrue(simpleMap.put("fasd", 3));
        assertTrue(simpleMap.put("vasdc", 4));
        assertTrue(simpleMap.put("aserasdf", 5));

        assertTrue(simpleMap.put("zxcrzxc", 6));
        assertTrue(simpleMap.put("bvxvxc8", 7));
        assertTrue(simpleMap.put("nnsdfg", 8));
        assertTrue(simpleMap.put(",tcddfgdf", 9));
        assertTrue(simpleMap.put("1000", 10));
        assertTrue(simpleMap.put("yuioyuiypym", 11));
        assertTrue(simpleMap.put("12", 12));
        assertTrue(simpleMap.put("13", 13));
        assertTrue(simpleMap.put("o4", 14));
        assertTrue(simpleMap.put("yy5", 15));
        assertTrue(simpleMap.put("atst16", 16));
        assertTrue(simpleMap.put("a17vcvta", 17));
    }

    @Test
    public void whenGetNotNull() {
        SimpleMap<String, Integer> simpleMap = new SimpleMap<>();
        assertTrue(simpleMap.put("Alexandra", 10));
        //assertTrue(simpleMap.get("Alexandra"), 10);
        assertEquals((simpleMap.get("Alexandra")), java.util.Optional.of(10).get());
    }

    @Test
    public void whenGetThenNull() {
        SimpleMap<String, Integer> simpleMap = new SimpleMap<>();
        assertNull(simpleMap.get("Alexandra"));
        assertNull(simpleMap.get("Ivan"));
    }

    @Test
    public void whenRemoveNotNullTheTrue() {
        SimpleMap<String, Integer> simpleMap = new SimpleMap<>();
        assertTrue(simpleMap.put("Alexandra", 10));
        assertTrue(simpleMap.remove("Alexandra"));
    }

    @Test
    public void whenRemoveNullTheFalse() {
        SimpleMap<String, Integer> simpleMap = new SimpleMap<>();
        assertTrue(simpleMap.put("Alexandra", 10));
        assertFalse(simpleMap.remove("Alexandra1"));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedKey() {
        SimpleMap<String, Integer> simpleMap = new SimpleMap<>();
        assertTrue(simpleMap.put("Alexandra", 10));
        Iterator<String> it = simpleMap.iterator();
        assertTrue(simpleMap.put("Boris", 200));
        it.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleMap<String, Integer> simpleMap = new SimpleMap<>();
        Iterator<String> it = simpleMap.iterator();
        simpleMap.iterator().next();
    }
}