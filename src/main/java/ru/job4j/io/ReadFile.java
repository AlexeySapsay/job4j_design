package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Программа выполняет чтение данных из файла
 * и выводит их на консоль
 * задача по ссылке: https://job4j.ru/profile/exercise/45/task-view/307
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 29.08.2021
 */

public class ReadFile {
    public static void main(String[] args) {
        // читаем файл в буфер
        try (BufferedReader in = new BufferedReader(new FileReader("input.txt"))) {
            in.lines().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
