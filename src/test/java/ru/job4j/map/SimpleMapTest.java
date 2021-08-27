package ru.job4j.map;

import org.junit.Test;

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
    public void testForExpand() {
        SimpleMap<String, Integer> simpleMap = new SimpleMap<>();
        assertTrue(simpleMap.put("0", 0));
        assertTrue(simpleMap.put("1", 1));
        assertTrue(simpleMap.put("2", 2));
        assertTrue(simpleMap.put("3", 3));
        assertTrue(simpleMap.put("4", 4));
        assertTrue(simpleMap.put("5", 5));

        assertTrue(simpleMap.put("6", 6));
        assertTrue(simpleMap.put("7", 7));
        assertTrue(simpleMap.put("8", 8));
        assertTrue(simpleMap.put("9", 9));
        assertTrue(simpleMap.put("10", 10));
        assertTrue(simpleMap.put("11", 11));
        assertTrue(simpleMap.put("12", 12));
        assertTrue(simpleMap.put("13", 13));
        assertTrue(simpleMap.put("14", 14));
        assertTrue(simpleMap.put("15", 15));
        assertTrue(simpleMap.put("16", 16));
        assertTrue(simpleMap.put("17", 17));
    }

//    @Test
//    public void whenPutThenFalse1() {
//        SimpleMap<String, Integer> simpleMap = new SimpleMap<>();
//        //assertTrue(simpleMap.put("Alex", 10));
//        assertFalse(simpleMap.put("Alex", 10));
//    }

//    @Test
//    public void whenCalculcateHashCode() {
//        //SimpleMap<String, Integer> simpleMap = new SimpleMap<>();
//        assertEquals(2043454, ("Alex").hashCode());
//    }

//    @Test
//    public void whenHash() {
//        assertEquals(2043454, ("Alex").hashCode());
//        assertEquals(0,whenHash(););
//    }


}