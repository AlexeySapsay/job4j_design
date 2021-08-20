package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Модель двусвязного списка. Аналог LinkedList
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 0.1
 * @since 19.08.2021
 */

public class SimpleLinkedList<E> implements List<E> {
    private Node<E> first;
    private Node<E> last;
    private int size = 0;
    private int modCount = 0;

    /**
     * Класс Node описывает вложенный класс, представляющий собой
     * узел LinkedList
     *
     * @param <E> принимаемый элемент для сохранения в узле
     */
    private static class Node<E> {
        private final E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    public SimpleLinkedList() {
    }

    /**
     * Добавление элемента в конец списка
     * элементы LinkedList использует объекты своего вложенного класса Node:
     * Node- узел.
     *
     * @param value добавляемый элемент
     */
    @Override
    public void add(E value) {
        Node<E> newNode = new Node<>(value, null);
        Node<E> tail = last;
        if (tail == null || size == 0) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
        modCount++;
    }

    /**
     * Извлечение элемента из списка по индексу
     *
     * @param index индекс элемента
     * @return элемент
     */
    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> rsl = first;
        for (int i = 0; i < index; i++) {
            rsl = rsl.next;
        }
        return rsl.element;
    }

    /**
     * Итератор для обхода коллекции
     *
     * @return new SimpleLinkedListIterator
     */
    @Override
    public Iterator<E> iterator() {
        class SimpleLinkedListIterator implements Iterator<E> {
            int expectedModCount = modCount;
            Node<E> currentNode = first;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return currentNode != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                E rsl = currentNode.element;
                currentNode = currentNode.next;
                return rsl;
            }
        }
        return new SimpleLinkedListIterator();
    }
}

