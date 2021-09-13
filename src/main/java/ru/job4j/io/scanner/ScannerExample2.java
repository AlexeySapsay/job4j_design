package ru.job4j.io.scanner;

import java.io.ByteArrayInputStream;
import java.util.Scanner;


/**
 * https://job4j.ru/profile/exercise/45/task-view/786
 *
 * Пример работ с классом Scanner
 * Пусть надо из потока данных вычленить почты, которые
 * разделы между собой “, ”. Можно поступить так:
 *
 * @since 13.09.2021
 */
public class ScannerExample2 {
    public static void main(String[] args) {
        var data = "empl1@mail.ru, empl2@mail.ru, empl3@mail.ru";
        var scanner = new Scanner(new ByteArrayInputStream(data.getBytes()))
                .useDelimiter(", ");
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }
}
