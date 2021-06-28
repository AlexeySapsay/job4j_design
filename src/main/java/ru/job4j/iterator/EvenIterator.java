package ru.job4j.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private final int[] returnArray;
    private int index = 0;

    public EvenIterator(final int[] numbers) {
        int[] bufferArray = new int[numbers.length];
        int counter = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                bufferArray[counter++] = number;
            }
        }
        this.returnArray = Arrays.copyOf(bufferArray, counter);
    }

    @Override
    public boolean hasNext() {
        return index < returnArray.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return returnArray[index++];
    }
}
