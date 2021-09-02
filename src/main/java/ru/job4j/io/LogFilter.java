package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    /**
     * @param file файл, содержащий логи для фильтрации
     * @return отфильтрованные логи, содежащие код 404
     */
    public static List<String> filter(String file) {
        List<String> buffer = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
        // читаем и выводим на консоль. Аналогичная запись без применения stream API
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                List<String> lineSplitedToWords = Arrays.asList(line.split(" "));
                if (lineSplitedToWords.get(lineSplitedToWords.size() - 2).contains("404")
                        && lineSplitedToWords.get(lineSplitedToWords.size() - 2).length() == 3) {
                    buffer.add(line);
                }
            }
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
    public static void save(List<String> log, String file) {
        List<String> logFilterResult = filter("log.txt");

        // открываем поток для записи в файл
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(new FileOutputStream(file)))) {
            for (String s : logFilterResult) {
                out.append(s);
                out.append(System.lineSeparator());
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        save(Collections.singletonList("log.txt"), "404.txt");
        System.out.println("Done");
    }
}
