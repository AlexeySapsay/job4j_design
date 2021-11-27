package ru.job4j.kiss;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MaxMinTest {

    @Test
    public void whenMaxThen1000() {
        List<Integer> integerList = List.of(1000, 10, 100, 1);
        MaxMin maxMin = new MaxMin();
        Integer result = maxMin.max(integerList, Integer::compareTo);
        assertThat(result, is(1000));
    }

    @Test
    public void whenMinThen1() {
        List<Integer> integerList = List.of(1000, 10, 100, 1);
        MaxMin maxMin = new MaxMin();
        Integer result = maxMin.min(integerList, Integer::compareTo);
        assertThat(result, is(1));
    }

    @Test
    public void whenMaxThenccc() {
        List<String> integerList = List.of("bb", "a", "ccc", "aaa");
        MaxMin maxMin = new MaxMin();
        String result = maxMin.max(integerList, String::compareTo);
        assertThat(result, is("ccc"));
    }

    @Test
    public void whenMinThena() {
        List<String> integerList = List.of("bb", "a", "ccc", "aaa");
        MaxMin maxMin = new MaxMin();
        String result = maxMin.min(integerList, String::compareTo);
        assertThat(result, is("a"));
    }
}