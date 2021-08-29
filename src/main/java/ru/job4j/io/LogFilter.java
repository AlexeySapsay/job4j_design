package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Программа выполняет чтение данных из файла
 * и выводит их на консоль
 * фильтруя записи по определенному условию
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 29.08.2021
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

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }
}
