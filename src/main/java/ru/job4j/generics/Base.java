package ru.job4j.generics;

/**
 * Модель базового объекта, хранимого в контейнере.
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 0.1
 * @since 14.08.2021
 */

public abstract class Base {
    /**
     * id- идентификатор объекта
     */
    private final String id;

    public Base(final String id) {
        this.id = id;
    }

    /**
     * Возвращает id идентификатор объекта
     *
     * @return возвращает уникальный идентификатор объекта
     */
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Base{"
                + "id='" + id + '\''
                + '}';
    }
}
