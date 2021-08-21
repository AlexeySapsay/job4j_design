package ru.job4j.collection;

import java.util.NoSuchElementException;

/**
 * Модель очередь. Аналог Queue на основе двух стеков
 * SimpleStack
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 0.1
 * @since 21.08.2021
 */
public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    /**
     * Взять элемент из SimpleStack in и добавить в SimpleStack out
     * Извлекаем элементы из in и помещаем в out
     * пока элементы не закончатся
     *
     * @return элемент после извлечения из SimpleStack in
     */
    public T poll() {
        T buffer;
        if (in.size() == 0 && out.size() == 0) {
            throw new NoSuchElementException();
        }
        if (out.size() > 0) {
            buffer = out.pop();
            return buffer;
        }
        while (in.size() != 0) {
            out.push(in.pop());
        }
        buffer = out.pop();
        return buffer;
    }

    /**
     * Добавляет элемент на вершину стэка
     *
     * @param value помещаяемый элемент
     */
    public void push(T value) {
        in.push(value);
    }
}
