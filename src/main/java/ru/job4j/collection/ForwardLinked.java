package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Модель двусвязного списка. Аналог LinkedList
 * Задача: написать метод для удаления Head
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 0.1
 * @since 20.08.2021
 */
public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    /**
     * Добавляем значение в ForwardLinked
     * @param value добавляемое значение
     */
    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    /**
     * Добавляем первый элемент
     *
     * @param value добавляемый элемент
     */
    public void addFirst(T value) {
        Node<T> node = new Node<>(value, null);
        node.next = head;
        head = node;
    }

    /**
     * Удаляем первую ноду из списка
     * @return новая текущая первая нода после удаления
     */
    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T headFirst = head.value;
        head = head.next;
        return headFirst;
    }

    /**
     * Итератор для обхода коллекции
     * @return Iterator возвращается в качестве значения
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    /**
     * Вложенный класс формирующий Node- узел
     * @param <T> тип данных, хранимый в узле
     */
    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
