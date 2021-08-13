package ru.job4j.iterator;

import java.util.*;

// https://job4j.ru/profile/exercise/38/task-view/275
// doc about emptyIterator
// https://www.javatpoint.com/java-collections-emptyiterator-method

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
        //return false;
        while (data.hasNext()) {
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


//public class FlatMap<T> implements Iterator<T> {
//    private final Iterator<Iterator<T>> data;
//    private Iterator<T> cursor = Collections.emptyIterator();
//    private Iterator<T> iterator = (new ArrayList<T>()).iterator();
//
//    // true to solve with code from stackOverflow
//    Iterator<T> convert(Iterator<Iterator<T>> data) {
//        return new Iterator<T>() {
//            @Override
//            public boolean hasNext() {
//                return false;
//            }
//
//            @Override
//            public T next() {
//                return null;
//            }
//
//            private Iterator<Integer> iterator = (new ArrayList<Integer>()).iterator();
//        };
//    }

//
//    @Override
//    public boolean hasNext() {
//        while (data.hasNext() && !iterator.hasNext()) {
//            iterator = data.next();
//        }
//        return iterator.hasNext();
//    }
//
//    @Override
//    public T next() {
//        if (!this.hasNext()) {
//            throw new NoSuchElementException();
//        }
//        return iterator.next();
//    }


//private T[] iterators;
//private int index = 0;

//    private List<T> temp = new ArrayList<>();
//
//    public FlatMap(Iterator<Iterator<T>> data) {
//        this.data = data;
//        while (data.hasNext()) {
//            Iterator<T> inner = data.next();
//            while (inner.hasNext()) {
//                temp.add(inner.next());
//            }
//        }
//    }

// right solution for task
//    public FlatMap(Iterator<Iterator<T>> data) {
//        this.data = data;
//        while (data.hasNext()) {
//            Iterator<T> cursor = data.next();
//            // remove el.hashCode
//            while (cursor.hasNext()) {
//                cursor.forEachRemaining(el -> el.hashCode());
//            }
//        }
//    }


//    @Override
//    public boolean hasNext() {
//return data.hasNext();
//this.cursor = cursor;
//return this.cursor = cursor;
//return false;
//return data.next();
//return iterators[index].hasNext();
//return iterators[index];
//return this.data.next().hasNext();
//        return true;
//return data;
//    }

//    @Override
//    public T next() {
//        if (!hasNext()) {
//            throw new NoSuchElementException();
//        }
//        if (iterators[index].hasNext()) {
//            return iterators[index].next();
//        } else {
//            return iterators[++index].next();
//        }
//        return cursor.next();
//return data.next();

//}

//    public static void main(String[] args) {
//        Iterator<Iterator<Integer>> data = List.of(
//                List.of(1, 2, 3).iterator(),
//                List.of(4, 5, 6).iterator(),
//                List.of(7, 8, 9).iterator()
//        ).iterator();
//
//        //FlatMap<Integer> flat = new FlatMap<>(data);
//        while (flat.hasNext()) {
//            System.out.println(flat.next());
//        }
//    }
//}
