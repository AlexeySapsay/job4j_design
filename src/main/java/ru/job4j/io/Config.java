package ru.job4j.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Изучение работы с потоками ввода- вывода
 * Чтение файла конфигурации
 * https://job4j.ru/profile/exercise/45/task-view/310
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 31.08.2021
 */


public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    /**
     * Метод load() - должен считать все ключи в карту values.
     * Важно в файле могут быть пустые строки и комментарии их нужно пропускать.
     */
    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(path))) {
            read.lines().
                    filter(s -> !s.contains("#") && s.length() > 0)
                    .forEach(string -> {
                        String[] buffer = string.split("=");
                        if (buffer.length != 2) {
                            throw new IllegalArgumentException();
                        }
                        values.put(buffer[0], buffer[1]);
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        new Config("./data/app.properties").load();
        System.out.println(new Config("./data/app.properties"));
    }
}

