package ru.job4j.iterator;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class ListUtilsTest {
    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test
    public void whenAddBeforeLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        ListUtils.addBefore(input, 2, 4);
        assertThat(Arrays.asList(1, 2, 4, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    // forward tests for method          addAfter
    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1));
        ListUtils.addAfter(input, 1, 2);
        //assertThat(Arrays.asList(0, 1), Is.is(input));
        assertThat(Arrays.asList(0, 1, 2), Is.is(input));
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(Arrays.asList(0, 1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddAfterWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 3, 3);
        assertThat(Arrays.asList(0, 1, 2, 3), Is.is(input));
    }

    @Test
    public void whenRemoveIfGreaterThanZeroThen0() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        ListUtils.removeIf(input, e -> e > 0);
        assertThat(Arrays.asList(0), Is.is(input));
    }

    @Test
    public void whenRemoveIfGreaterThan3Then0123() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        ListUtils.removeIf(input, e -> e > 3);
        assertThat(Arrays.asList(0, 1, 2, 3), Is.is(input));
    }

    @Test
    public void whenRemoveIfEven() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        ListUtils.removeIf(input, e -> e % 2 == 0);
        assertThat(Arrays.asList(1, 3, 5), Is.is(input));
    }

    @Test
    public void whenReplaceIfEven() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        ListUtils.replaceIf(input, e -> e % 2 == 0, 9);
        assertThat(Arrays.asList(9, 1, 9, 3, 9, 5), Is.is(input));
    }

    @Test
    public void whenReplaceIfOdd() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        ListUtils.replaceIf(input, e -> e % 2 != 0, 11);
        assertThat(Arrays.asList(0, 11, 2, 11, 4, 11), Is.is(input));
    }

    @Test
    public void whenRemoveAllOneElement() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0));
        List<Integer> elements = new ArrayList<>(Arrays.asList(0));
        ListUtils.removeAll(input, elements);
        assertThat(Arrays.asList(), Is.is(input));
    }

    @Test
    public void whenRemoveAllTwoElements() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1));
        List<Integer> elements = new ArrayList<>(Arrays.asList(1, 0));
        ListUtils.removeAll(input, elements);
        assertThat(Arrays.asList(), Is.is(input));
    }

    @Test
    public void whenRemoveAllManyElements() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 4, 4));
        List<Integer> elements = new ArrayList<>(Arrays.asList(0, 4));
        ListUtils.removeAll(input, elements);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }
}