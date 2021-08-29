package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;

/**
 * Программа выполняет чтение данных из файла
 * и выводит их на консоль
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 29.08.2021
 */

//https://job4j.ru/profile/exercise/45/task-view/307
public class ReadFile {
    public static void main(String[] args) {
        // читаем по байтово файл
        //        try (FileInputStream in = new FileInputStream("input.txt")) {
//            StringBuilder text = new StringBuilder();
//            int read;
//            while ((read = in.read()) != -1) {
//                text.append((char) read);
//            }
//            String[] lines = text.toString().split(System.lineSeparator());
//            for (String line : lines) {
//                System.out.println(line);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // читаем файл в буфер

        try (BufferedReader in = new BufferedReader(new FileReader("input.txt"))) {
            in.lines().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
