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
    int lengthCounter = 0;

    /**
     * Подсчет количества элементов в ForwardLinked
     *
     * @return количество элементов в ForwardLinked
     */
    public int size() {
        return lengthCounter;
    }

    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Добавляем значение в ForwardLinked
     *
     * @param value добавляемое значение
     */
    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            lengthCounter++;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        lengthCounter++;
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
        lengthCounter++;
    }

    /**
     * Удаляем первую ноду из списка
     *
     * @return новая текущая первая нода после удаления
     */
    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T headFirst = head.value;
        head = head.next;
        lengthCounter--;
        return headFirst;
    }

    /**
     * Переворачивает односвязный список из 123 в 321
     * @return true- в случае успешного реверска, и false
     * в случае провала
     */
    public boolean revert() {
        if (isEmpty() || lengthCounter == 1) {
            return false;
        }
        Node<T> current = head;
        Node<T> previous = null;

        while (current != null) {
            Node<T> next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        return true;
    }

    /**
     * Итератор для обхода коллекции
     *
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
     *
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
