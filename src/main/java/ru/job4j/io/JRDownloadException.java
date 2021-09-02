package ru.job4j.io;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
DownloadException
*/

/**
 * 1 Считывать с консоли имена файлов.
 * 2 Если файл меньше 1000 байт, то:
 * 2.1 Закрыть потоки работы с файлами.
 * 2.2 Выбросить исключение DownloadException.
 */

public class JRDownloadException {
    public static void main(String[] args) throws DownloadException, IOException {
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();

            int[] byteCountArray = new int[1000];
            try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
                if (fileInputStream.available() <= 1000) {
                    throw new DownloadException();
                }
                while (fileInputStream.available() > 0) {
                    byteCountArray[fileInputStream.read()] += 1;
                }
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
