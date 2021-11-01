package ru.job4j.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Исправить функциональность в соответствии с требованиями.
 * <p>
 * Программа должна:
 * 1. Переписать все байты одного файла в другой одним куском.
 * 2. Закрывать потоки ввода-вывода.
 * <p>
 * Подсказка:
 * 4 ошибки.
 */
public class JRWriteBytesFromFile1ToFile2 {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("c:/data.txt");
        /**
         * Создаем поток-записи-байт-в-файл
         */
        FileOutputStream outputStream = new FileOutputStream("c:/result.txt");
        /**
         *  Все что считали из файла result сохраняем в буфер
         */
        byte[] buffer = new byte[inputStream.available()];
        /**
         * читаем из буфера пока, пока буфер не закончится и записывает во второй файл
         */
        if (inputStream.available() > 0) {
            /**
             * читаем весь файл одним куском
             */
            int count = inputStream.read(buffer);
            outputStream.write(buffer, 0, count);
        }
        /**
         * закрывает рабочие потоки
         */
        inputStream.close();
        outputStream.close();
    }
}

