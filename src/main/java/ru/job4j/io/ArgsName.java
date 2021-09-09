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


        // чистим ключ от первого тире -
        // и пару закидываем в хэшмапу

        // проводим валидацию
        validation(args);

        // разбить значения по пробелам получим связанные ключ=значение
        // после пару разбить по знаку равно получим ключ значение


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
            if (str.length() == 0 && !str.contains("=")) {
                throw new IllegalArgumentException(" Arguments is not correct:"
                        + "Use argument like this: -Xmx=514");
            }
        }

    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));

        ArgsName pip = ArgsName.of(new String[]{"project.zip", "-encoding=UTF-8"});
        System.out.println(pip.get("out"));
    }
}
