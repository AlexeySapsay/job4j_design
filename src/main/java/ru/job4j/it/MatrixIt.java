package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (row < data.length && data[row].length == column) {
            row++;
            column = 0;
        }
        return row < data.length && data[row].length > column;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int x = data[row][column];

        if (data[row][column] > data.length) {
            row++;
        } else {
            column++;
        }
        return x;

    }
}
