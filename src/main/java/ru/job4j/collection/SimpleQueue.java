package ru.job4j.collection;
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

    public T poll() {
        return null;
    }

    public void push(T value) {

    }
}
