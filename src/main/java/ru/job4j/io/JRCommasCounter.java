package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * С консоли считать имя файла.
 * Посчитать в файле количество символов ',', количество вывести на консоль.
 * Закрыть потоки.
 * <p>
 * Подсказка:
 * нужно сравнивать с ascii-кодом символа ','.
 */
public class JRCommasCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        int counter = 0;
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();
                if (data == 44) {
                    counter++;
                }
            }
            System.out.println(counter);
        }
    }
}