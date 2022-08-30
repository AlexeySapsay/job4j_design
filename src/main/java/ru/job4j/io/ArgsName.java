package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    /**
     * Геттер для получения значения value по ключу key
     *
     * @param key ключь для извлечения значения value из hashMap
     * @return value, возвращаемоое значение из хэшмапы
     */
    public String get(String key) {
        return values.get(key);
    }

    /**
     * Метод получения множества ключей
     *
     * @return множество ключей из values
     */
    public Set<String> getKeys() {
        return values.keySet();
    }

    /**
     * Метод валидации входных параметров,
     * заданных через терминал или командную строку
     *
     * @param args параметры, полученные из терминала или командной строки
     */
    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Use correct argument like key=value");
        }
        for (String str : args) {
            String[] keyAndValue = str.split("=");
            if (keyAndValue.length < 2) {
                throw new IllegalArgumentException("Use like key=value");
            }
            String key = keyAndValue[0];
            String value = keyAndValue[1];
            values.put(key.substring(1), value);
        }
    }

    public ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
    }
}
