package ru.job4j.collection.set;

import ru.job4j.collection.SimpleArray;

import java.util.Iterator;
import java.util.Objects;

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
     * <p>
     * П.с. Т.к в set может хранится null значение, то для корректного
     * сравнения объектов предпочтительнее
     * использовать Objects.equals() вместо Object.equals()
     *
     * @param value добавляемое значение
     * @return true если элемента в колекции нет и он
     * был добавлен(колекция изменена). В противном случае
     * вернет false.
     */
    @Override
    public boolean add(T value) {
        if (contains(value)) {
            return false;
        }
        set.add(value);
        return true;
    }

    /**
     * метод возвращает true, если множество содержит переданный в
     * метод элемент e. Сравнение объектов выполняется с помощью метода equals().
     *
     * П.с. В set может хранится null значение, то для корректного
     * сравнения объектов предпочтительнее
     * использовать Objects.equals() вместо Object.equals()
     *
     * @param value искомое значение
     * @return true если множество содержит искомый элемент. И false в
     * противном случае.
     */
    @Override
    public boolean contains(T value) {
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            if (Objects.equals(it.next(), value)) {
                return true;
            }
        }
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
