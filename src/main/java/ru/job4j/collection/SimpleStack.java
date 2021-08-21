package ru.job4j.collection;

/**
 * Модель стека. Аналог Stack на основе LinkedList
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 0.1
 * @since 21.08.2021
 */
public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    /**
     * Метод pop() - должен возвращать значение
     * и удалять его из коллекции.
     *
     * @return возвращаемое значением, удаляем его из коллекции
     */
    public T pop() {
        return linked.deleteFirst();
    }

    /**
     * Метод push(T value) - помещает значение в коллекцию.
     *
     * @param value помещаемое значение
     */
    public void push(T value) {
        linked.addFirst(value);
    }
}
