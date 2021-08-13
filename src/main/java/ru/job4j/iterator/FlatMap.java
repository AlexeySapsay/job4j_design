package ru.job4j.iterator;

import java.util.*;

// https://job4j.ru/profile/exercise/38/task-view/275
// doc about emptyIterator
// https://www.javatpoint.com/java-collections-emptyiterator-method
//https://ru.stackoverflow.com/questions/612458
// /%D0%9E%D0%B1%D1%8A%D0%B5%D0%B4%D0%B8%D0%BD%D0%B5%D0%BD%D0%B8%D0%B5
// -%D0%B8%D1%82%D0%B5%D1%80%D0%B0%D1%82%D0%BE%D1%80%D0%BE%D0%B2-%D1%81
// -%D0%BF%D0%BE%D0%BC%D0%BE%D1%89%D1%8C%D1%8E
// -%D0%B8%D1%82%D0%B5%D1%80%D0%B0%D1%82%D0%BE%D1%80%D0%B0
// -%D0%B8%D1%82%D0%B5%D1%80%D0%B0%D1%82%D0%BE%D1%80%D0%BE%D0%B2
/**
 *
 * @param <T>
 */

public class FlatMap<T> implements Iterator<T> {
    private final Iterator<Iterator<T>> data;
    private Iterator<T> cursor = Collections.emptyIterator();

    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (data.hasNext()  && !cursor.hasNext()) {
            cursor = data.next();
        }
        return cursor.hasNext();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return cursor.next();
    }

    public static void main(String[] args) {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1, 2, 3).iterator(),
                List.of(4, 5, 6).iterator(),
                List.of(7, 8, 9).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        while (flat.hasNext()) {
            System.out.println(flat.next());
        }
    }
}
