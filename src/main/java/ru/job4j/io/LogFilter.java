package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Программа выполняет чтение данных из файла
 * и выводит их на консоль
 * фильтруя записи по условию:
 * предпоследним значением дожно быть 404
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 30.08.2021
 */
public class LogFilter {
    public static List<String> filter(String file) {
        List<String> buffer = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader("log.txt"))) {
            buffer.add(in.lines().filter(i -> i.contains("404"))
                    .collect(Collectors.toList()).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer;
    }

    /**
     * Метод должен записывать результат фильтрации в файл.
     *
     * @param log  list логов свежих, грязных и не фильтрованных сообщений,
     *             берем логи отседова
     * @param file файл для сохранения результатов фильтрации, сгружаем
     *             чистые и отфильтрованные логи сюда!
     */
    public static void save(List<String> log, String file) throws IOException {
        List<String> logFilterResult = filter("log.txt");
        // открываем поток для записи в файл
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)))) {
            for (String stre : logFilterResult) {
                out.println(stre);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> log = filter("log.txt");
        save(log, "404.txt");
        //System.out.println(log);
    }
}
