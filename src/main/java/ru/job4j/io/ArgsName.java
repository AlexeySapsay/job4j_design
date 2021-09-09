package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

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
     * @return value, возвращаемоое значение из базы
     */
    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        /* TODO parse args to values. */


        // и пару закидываем в хэшмапу

        // проводим валидацию
        validation(args);

        // после пару разбить по знаку равно получим ключ значение
        // чистим ключ от первого тире -
        for (String str : args) {
            String key = "";
            String value = "";

            String[] keyAndValue = str.split("=");
            key = keyAndValue[0];
            value = keyAndValue[1];
            System.out.println("key: " + key + System.lineSeparator()
                    + "value :" + value);
        }


        //System.out.println(args);
    }

    public static ArgsName of(String[] args) {
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
    public static void validation(String[] args) {
        for (String str : args) {
//            if (args[str].length() == 0 && !args[0].contains("=")) {
//                throw new IllegalArgumentException(" Arguments is not correct:"
//                        + "Use argument like : -Xmx=514");
//            }


            if (str.length() == 0 || !str.contains("=")) {
                throw new IllegalArgumentException(" Arguments is not correct:"
                        + "Use argument like this: -Xmx=514");
            }
            // возможно здесь нужно делать парсинг стринга
            // разбирвать на ключь и значение и проверять
            // наличие ключа и значения по длине
            // наличие =
            String[] strings;
            strings = str.split("=");
            System.out.println("strings.length : " + strings.length);
            if (strings.length != 2) {
                throw new IllegalArgumentException(
                        System.lineSeparator()
                                + "That form arguments is not correct:     -Xmx=   OR    =514"
                                + System.lineSeparator()
                                + "Use argument like this: -Xmx=514");
            }

            if ((strings[0].length() == 0) || (strings[1].length() == 0)) {
                throw new IllegalArgumentException(" Arguments is not correct:"
                        + " THAT FORM is not correct:     -Xmx=   OR    =514"
                        + "Use argument like this: -Xmx=514");
            }
        }
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));

        ArgsName pip = ArgsName.of(new String[]{"-out=", "-encoding=UTF-8"});
        System.out.println(pip.get("out"));
    }
}
