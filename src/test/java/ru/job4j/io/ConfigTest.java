package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ConfigTest {
    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.name"), is("Alexey Sapsay"));
    }

    @Test
    public void whenPairWithComment() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.name"), is("Alexey"));
        assertThat(config.value("hibernate.connection.surname"), is("Sapsay"));
    }

    @Test
    public void whenPairWithCommentAndNullValue() {
        String path = "./data/pair_with_comment_and_null_value.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.name"), is("Alexey"));
        assertThat(config.value("hibernate.connection.surname"), is("Sapsay"));
    }
}