package ru.job4j.tdd;

import org.junit.Ignore;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class GeneratorTest {
    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testWhenKeyInTemplateNotInMapThenThrowException() {
        String template = new String();

        List<String> words = new ArrayList<>();
        words.addAll(Arrays.asList(template.split(" ")));
        words.removeIf(word -> (!word.contains("$")));
        ((ArrayList<String>) words).trimToSize();

        /**
         *и дальше очищаем от {}, знаков препинания и получаем
         * коллекцию содержащию чистые name, subject
         */

        Map<String, String> map = new HashMap<>();
        for (String word : words) {
            if (!map.containsKey(word) && !map.containsValue(word)) {
                throw new IllegalArgumentException("That name not contains in map");
            }
        }
    }

}