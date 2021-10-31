package ru.job4j.collection.tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @param <E> параметризованный тип данных
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 28.08.2021
 */


public interface Tree<E> {
    /**
     * Метод add - Должен находить узел по значению parent
     * и добавлять в него дочерний узел со значением child.
     * В этом методе нужно проверить, что значения child еще нет
     * в дереве а parent есть. Если child есть, то метод должен вернуть false.
     *
     * @param parent родитель, куда будем добавлять элемент
     * @param child  потомок, какой элемент добавляем
     * @return Если child есть, то метод должен вернуть false.
     * В другом случае возвращает true
     */
    boolean add(E parent, E child);

    /**
     * Это класс использовать алгоритм обхода в ширину.
     * В этом задании мы не будем касаться устройства работы этого алгоритма.
     * Вам нужно воспользоваться результатом его работы для реализации метода add.
     *
     * поиск node E, по value
     * Когда value отсутствует во всем дереве, то возвращается return = Optional.empty();
     *
     * @param value значение для поиска
     * @return Optional Node E
     */
    Optional<Node<E>> findBy(E value);

    /**
     * Проверка дерева на бинарность.
     *
     * @return true в случае если дерево бинарное,
     * false в противном случае
     */
    boolean isBinary();

    class Node<E> {
        final E value;
        final List<Node<E>> children = new ArrayList<>();

        public Node(E value) {
            this.value = value;
        }
    }
}
