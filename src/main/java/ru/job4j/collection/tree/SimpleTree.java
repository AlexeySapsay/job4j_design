package ru.job4j.collection.tree;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;

/**
 * https://job4j.ru/profile/exercise/43/task-view/301
 * В этом уроке мы познакомимся с алгоритмом обхода
 * дерева в ширину - breadth first search.
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 27.10.2021
 */

public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        Node<E> parentNode = findBy(parent).orElse(null);
        if (parentNode == null) {
            throw new NoSuchElementException();
        }
        return findBy(child).isPresent() ? false
                : parentNode.children.add(new Node<>(child));
    }

    /**
     * Это класс использует алгоритм обхода в ширину.
     * В этом задании мы не будем касаться устройства работы этого алгоритма.
     * Вам нужно воспользоваться результатом его работы для реализации метода add.
     * <p>
     * поиск node E, по value
     * Когда value отсутствует во всем дереве, то возвращается return = Optional.empty();
     *
     * @param value значение для поиска
     * @return Optional Node E
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        return findByPredicate(valueE ->
                valueE.value.equals(value));
    }

    /**
     * Метод должен проверять количество дочерних элементов
     * в дереве. Если их > 2 - то дерево не бинарное
     *
     * @return Если их > 2 - то дерево не бинарное , вернуть false
     * в противном случае, если =2, то дерево бинарное и вернуть true.
     */
    public boolean isBinary() {
        return findByPredicate(value ->
                value.children.size() > 2).isEmpty();
    }

    /**
     * Обратите внимание, что методы isBinary() и findBy() идентичны.
     * Ваша задача отрефакторить код, создав
     * вспомогательный метод. Это метод уже использовать в методах
     * isBinary() и findBy()
     *
     * @param condition условие для чего?
     * @return Optional<Node> or null если значение не найденно
     */
    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> element = data.poll();
            if (condition.test(element)) {
                rsl = Optional.of(element);
                break;
            }
            data.addAll(element.children);
        }
        return rsl;
    }
}

