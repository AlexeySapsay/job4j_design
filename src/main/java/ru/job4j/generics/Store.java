package ru.job4j.generics;

/**
 * Интерфейс универсальной структуры данных(контейнера),
 * хранящего объекты.
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 0.1
 * @since 14.08.2021
 */

public interface Store<T extends Base> {

    /**
     * Добавить элемент model в контейнер
     *
     * @param model добавляемый элемент
     */
    void add(T model);

    /**
     * Замена элемента в контейнере.
     *
     * @param id  Идентификатор элемента в контейнере.
     * @param model  добавляемый элемент в контейнер.
     * @return true возвращает  в случае успешной замены,
     * в противном случае - вернет false.
     */
    boolean replace(String id, T model);

    /**
     * Удаление элемента из контейнера
     *
     * @param id идентификатор элемента.
     * @return возвращает True в случае успешного удаления, иначе false.
     */
    boolean delete(String id);

    /**
     * Поиск элемента в контейнере.
     *
     * @param id Идентификатор искомого элемента.
     * @return возвращаем найденный элемент.
     */
    T findById(String id);
}
