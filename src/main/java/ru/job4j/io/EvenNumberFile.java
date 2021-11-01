package ru.job4j.io;

/**
 *https://job4j.ru/profile/exercise/45/task-view/307
 */

import java.io.FileInputStream;

/**
 * Программа выполняет чтение данных из файла
 * проверяет четное число или нет и выводит
 * результат на консоль
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 29.08.2021
 */
public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                if (Integer.parseInt(line) % 2 == 0) {
                    System.out.println(line + " : is " + "even");
                } else {
                    System.out.println(line + " : is " + "odd");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
