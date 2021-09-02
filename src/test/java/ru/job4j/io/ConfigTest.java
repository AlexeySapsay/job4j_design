package ru.job4j.io;

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

    @Test
    public void whenPairWithCommentAndNullValue2() {
        String path = "./data/pair_with_comment_and_null_value2.properties";
        Config config = new Config(path);
        config.load();

        assertThat(config.value("hibernate.connection.surname"), is("Sapsay"));
    }

    @Test
    public void whenPairWithCommentAndNullValue3() {
        String path = "./data/pair_with_comment_and_null_value3.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.database"), is("postgresql"));
        assertThat(config.value("hibernate.dialect"), is("org.hibernate.dialect.PostgreSQLDialect"));
        assertThat(config.value("hibernate.connection.driver_class"), is("org.postgresql.Driver"));
        assertThat(config.value("hibernate.connection.username"), is("postgresql1"));
    }
}