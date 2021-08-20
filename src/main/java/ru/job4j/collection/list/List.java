package ru.job4j.collection.list;

/**
 * Интерфейс двусвязного списка. Аналог LinkedList
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 0.1
 * @since 19.08.2021
 */


public interface List<E> extends Iterable<E> {
    void add(E value);

    E get(int index);
}
