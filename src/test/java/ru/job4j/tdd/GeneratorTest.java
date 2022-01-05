package ru.job4j.tdd;

import org.junit.Ignore;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class GeneratorTest {
    @Ignore
    @Test
    public void testWhenKeyInTemplateNotInMap() {
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>();

        map.put("name", "Petr Arsentev");
        map.put("subject", "you");

        String rsl = "I am a Petr Arsentev, Who are you? ";
        GeneratorImplementation gI = new
                GeneratorImplementation();
        assertThat(rsl, is(gI.produce(template, map)));
    }
}