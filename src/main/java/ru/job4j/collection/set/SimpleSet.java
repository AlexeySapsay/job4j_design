package ru.job4j.collection.set;

import ru.job4j.collection.SimpleArray;

import java.util.Iterator;

/**
 * Модель Set - SimpleSet, для работы с коллекциями имплеминтирующие
 * интерфейс Set
 * Задача: написать недастающие методы и тесты для них
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 0.1
 * @since 23.08.2021
 */
public class SimpleSet<T> implements Set<T> {
    private SimpleArray<T> set = new SimpleArray<>();

    /**
     * 1.1. boolean add(E e) – добавляет элемент в множество и при этом
     * возвращает true только в том случае, если такого элемента еще нет
     * в наборе данных. Если уже такой элемент имеется в коллекции
     * - метод вернет false и набор данных при этом не изменится.
     * Равенство объектов определяется по методу equals()
     *
     * @param value добавляемое значение
     * @return true если элемента в колекции нет и он
     * был добавлен(колекция изменена). В противном случае
     * вернет false.
     */
    @Override
    public boolean add(T value) {
        //int containsFlag = 0;
//        Iterator<T> iterator = set.iterator();
//        while (iterator.hasNext()) {
//            if (iterator.next() == value) {
//                return false;
//            }
//        }


//        if (contains((T) set)) {
//            //true
//            return false;
//        }
//        //false
//        set.add(value);
//        return true;


//        if (contains((T) set)) {
//            return false;
//            //return true;
//        }
//        set.add(value);
//        //return false;
//        return true;


        if (contains((T) set)) {
            // contains = true,
            // add= false
            return false;
        }
        // contains = false,
        // add = true
        set.add(value);
        return true;
    }

    /**
     * метод возвращает true, если множество содержит переданный в
     * метод элемент e. Сравнение объектов выполняется с помощью метода equals().
     *
     * @param value искомое значение
     * @return true если множество содержит искомый элемент. И false в
     * противном случае.
     */
    @Override
    public boolean contains(T value) {
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            //if (it.next() == value) {
            if (it.next().equals(value)) {
                System.out.println("Element " + value.toString()
                        + " in collection. Then return contains TRUE");
                return true;
            }
        }
        System.out.println("Element " + value.toString()
                + " NOT in collection. "
                + "Then return contains FALSE");
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SimpleSet<?> simpleSet = (SimpleSet<?>) o;

        return set != null ? set.equals(simpleSet.set) : simpleSet.set == null;
    }

    @Override
    public int hashCode() {
        return set != null ? set.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "SimpleSet{"
                + "set=" + set
                + '}';
    }
}
