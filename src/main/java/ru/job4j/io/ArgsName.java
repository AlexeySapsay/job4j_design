package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * https://job4j.ru/profile/exercise/45/task-view/317
 * <p>
 * написать программу, которая принимает
 * массив параметров и разбивает их на пары: ключ, значение.
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 08.09.2021
 */

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

    public Set<String> getKeys() {
        return values.keySet();
    }

    private void parse(String[] args) {
        validation(args);

        for (String str : args) {
            String[] keyAndValue = str.split("=");
            String key = keyAndValue[0];
            String value = keyAndValue[1];

            key = key.substring(1);
            values.put(key, value);
        }
    }

    public ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    /**
     * Метод валидации входных параметров,
     * заданных через терминал или командную строку
     *
     * @param args параметры, полученные из терминала или командной строки
     */
    public void validation(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException(" Arguments is not correct:"
                    + System.lineSeparator()
                    + "Arguments is null"
                    + "Use argument like this: -Xmx=514");
        }
        for (String str : args) {
            if (str.length() == 0 || !str.contains("=")) {
                throw new IllegalArgumentException(" Arguments is not correct:"
                        + "Use argument like this: -Xmx=514");
            }

            String[] strings;
            strings = str.split("=");
            //System.out.println("strings.length : " + strings.length);
            if (strings.length != 2) {
                throw new IllegalArgumentException(
                        System.lineSeparator()
                                + "That form arguments is not correct: -Xmx= OR =514"
                                + System.lineSeparator()
                                + "Use argument like this: -Xmx=514");
            }
        }
    }

    public static void main(String[] args) {

    }
}
