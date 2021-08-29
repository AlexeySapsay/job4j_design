package ru.job4j.io;

import java.io.FileOutputStream;
import java.util.Arrays;

import static ru.job4j.io.Matrix.multiple;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result1.txt")) {
            out.write(Arrays.deepToString(multiple(10)).getBytes());
            out.write(System.lineSeparator().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}