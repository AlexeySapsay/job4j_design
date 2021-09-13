package ru.job4j.io.scanner;

import java.io.*;
import java.util.Scanner;

/**
 * https://job4j.ru/profile/exercise/45/task-view/786
 * <p>
 * Пример работ с классом Scanner
 * Еще одной интересной возможностью Scanner является
 * возможность задать систему счисления при чтении чисел.
 * Например, можно прочитать числа
 * в шестнадцатеричном виде и вывести в десятичном таким образом:
 *
 * @since 13.09.2021
 */
public class ScannerExample3 {
    public static void main(String[] args) {
        var data = "A 1B FF 110";
        File file = null;
        try {
            file = File.createTempFile("data", null);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        try {
            try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file))) {
                out.write(data.getBytes());
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        try (var scanner = new Scanner(file).useRadix(16)) {
            while (scanner.hasNextInt()) {
                System.out.println(scanner.nextInt());
                System.out.println(" ");
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
