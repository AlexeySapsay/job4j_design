package ru.job4j.ood.lsp.strategy;

import java.util.Objects;

/**
 * LSP практика на примере геометрических фигур. Квадрата и прямоугольника
 * реализация шаблона стратегия
 *
 * @author Alexey Sapsay
 * @version 1.0
 * @since 22.10.2022
 */

public  class Rectangle {
    private int a;
    private int b;

    private float square;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }


    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Rectangle rectangle = (Rectangle) o;
        return a == rectangle.a && b == rectangle.b && Float.compare(rectangle.square, square) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, square);
    }

    @Override
    public String toString() {
        return "Rectangle{" + "a=" + a
                + ", b=" + b
                + ", square=" + square
                + '}';
    }
}
