package ru.job4j.iterator;

import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.function.Predicate;

public class ListUtils {
    /**
     * Метод который будет вставлять значение перед индексом
     *
     * @param list  Лист, который будем индексировать, от 0 до size-1
     * @param index позиция для вставки
     * @param value значение для вставки
     * @param <T> data type
     */
    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.nextIndex() == index) {
                i.add(value);
                break;
            }
            i.next();
        }
    }

    /**
     * Метод который будет вставлять значение после индекса
     *
     * @param list  Лист, который будем индексировать, от 0 до size - 1
     * @param index позиция для вставки
     * @param value значение для вставки
     * @param <T>   тип данных, с которым работает коллекция и класс
     */
    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.nextIndex() == index && i.nextIndex() != list.size()) {
                i.next();
                i.add(value);
                break;
            }
            i.next();
        }
    }

    /**
     * Метод удаляет все элементы, которые удовлетворяют предикату
     *
     * @param list Лист, который будем индексировать, от 0 до size - 1
     * @param filter условие по которому происходит фильтрация
     * @param <T>  тип данных, с которым работает коллекция и класс
     */
    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (filter.test(i.next())) {
                i.remove();
            }
        }
    }

    /**
     * replaceIf() заменяет все элементы, которые удовлетворяют предикату;
     *
     * @param list   лист входных значений
     * @param filter условие для изменения
     * @param value  заменяется на данное значение при filter==true
     * @param <T>    дженерик для параметризации метода, контейнера и классов коллекций
     */
    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (filter.test(i.next())) {
                i.set(value);
            }
        }
    }

    /**
     * Метод удаляет все элементы, которые находятся в List elements
     *
     * @param list     входной лист значений
     * @param elements элементы которые будут удаленны во входном list
     * @param <T>      тип данных для класса и входных данных
     */
    public static <T> void removeAll(List<T> list, List<T> elements) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (elements.contains(i.next())) {
                i.remove();
            }
        }
    }
}
