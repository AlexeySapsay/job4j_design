package ru.job4j.io;

import java.io.FileOutputStream;
import java.util.Arrays;

/**
 * Таблица умножения на двухмерном массиве.
 * Запись в вайл
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 29.08.2021
 */

public class Matrix {
    public static int[][] multiple(int size) {
        int[][] table = new int[size][size];
        int multiplicator1 = 1;
        for (int row = 0; row < table.length; row++) {
            int multiplicator2 = 1;
            for (int cell = 0; cell < table.length; cell++) {
                table[row][cell] = multiplicator1 * multiplicator2;
                multiplicator2++;
            }
            multiplicator1++;
        }
        return table;
    }

    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("resultMultiplicatioMatrix.txt")) {
            out.write(Arrays.deepToString(multiple(10)).getBytes());
            out.write(System.lineSeparator().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
