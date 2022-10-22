package ru.job4j.ood.lsp.strategy;

public class CalculateArea {
    public static int calculateRectangle(int a, int b) {
        if (a == 0 || b == 0) {
            throw new IllegalArgumentException("Argument can't be 0");
        }
        return a * b;
    }

    public static int calculateSquare(int a, int b) {
        return a * a;
    }
}
