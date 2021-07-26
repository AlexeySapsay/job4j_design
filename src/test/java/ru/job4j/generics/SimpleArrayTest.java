package ru.job4j.generics;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.*;

public class SimpleArrayTest {
    @Test
    public void addWhenPlaceExistThenAdd() {
        SimpleArray<Integer> result = new SimpleArray<>(2);
        result.add(1);
        result.add(2);

        SimpleArray<Integer> expected = new SimpleArray<>(2);
        expected.add(1);
        expected.add(2);

        assertEquals(expected, result);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addWhenPlaceNotExistThenIndexOutOfBoundsException() {
        SimpleArray<Integer> result = new SimpleArray<>(2);
        result.set(0, 0);
        result.set(1, 1);

        SimpleArray<Integer> expected = new SimpleArray<>(2);
        expected.set(0, 0);
        expected.set(1, 1);
        expected.add(2);
    }

    @Test
    public void set2ValueWhenIndexExistThenSet() {
        SimpleArray<Integer> result = new SimpleArray<>(2);
        result.set(0, 1);
        result.set(1, 1);

        SimpleArray<Integer> arrayExpected = new SimpleArray<>(2);
        arrayExpected.set(0, 1);
        arrayExpected.set(1, 1);

        assertEquals(arrayExpected, result);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setWhenIndexNotExistThenNotExistThenIndexOutOfBoundsException() {
        SimpleArray<Integer> result = new SimpleArray<>(1);
        result.set(0, 1);
        result.set(1, 1);
    }

    @Test
    public void removeWhenIndexExistThenRemove() {
        SimpleArray<Integer> result = new SimpleArray<>(3);
        result.set(0, 0);
        result.set(1, 1);
        result.set(2, 2);
        result.remove(0);

        SimpleArray<Integer> expected = new SimpleArray<>(2);
        expected.set(0, 1);
        expected.set(1, 2);
        assertTrue(result.get(0).equals(1));
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void removeWhenIndexNotExistThenExeptionIOBE() {
        SimpleArray<Integer> result = new SimpleArray<>(2);
        result.set(0, 0);
        result.set(1, 1);

        SimpleArray<Integer> expected = new SimpleArray<>(2);
        expected.set(0, 0);
        expected.set(1, 1);

        expected.remove(2);
    }

    @Test
    public void getWhenIndexExistThenGet() {
        SimpleArray<Integer> result = new SimpleArray<>(2);
        result.set(0, 0);
        result.set(1, 1);

        SimpleArray<Integer> expected = new SimpleArray<>(2);
        expected.set(0, 0);
        expected.set(1, 1);

        assertEquals(expected.get(1), result.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getWhenIndexExistThenExeptionIOBE() {
        SimpleArray<Integer> result = new SimpleArray<>(2);
        result.set(0, 0);
        result.set(1, 1);

        SimpleArray<Integer> expected = new SimpleArray<>(2);
        expected.set(0, 0);
        expected.set(1, 1);

        assertEquals(expected.get(2), result);
    }

    @Test
    public void whenHasNextAndNext() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(3);
        simpleArray.add(0);
        simpleArray.add(1);
        simpleArray.add(2);

        Iterator<Integer> iterator = simpleArray.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(0));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(false));
    }
}