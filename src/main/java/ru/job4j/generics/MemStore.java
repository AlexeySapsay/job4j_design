package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;

/**
 * Структура универсального хранилища.
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 0.1
 * @since 14.08.2021
 */

public class MemStore<T extends Base> implements Store<T> {
    private final Map<String, T> mem = new HashMap<>();

    /**
     * Добавляем элемент в хранилище
     *
     * @param model добавляемый элемент
     */
    @Override
    public void add(T model) {
        mem.put(model.getId(), model);
    }

    /**
     * Заменить элемент в хранилище, используя идентификатор id
     *
     * @param id    Идентификатор элемента в контейнере.
     * @param model добавляемый элемент в контейнер.
     * @return true  в случае успешной замены, иначе false.
     */
    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        if (mem.containsKey(id)) {
            mem.remove(id);
            mem.put(id, model);
            result = true;
        }
        return result;
    }

    /**
     * Удаление элемента из хранилища.
     *
     * @param id идентификатор элемента для удаления.
     * @return вернет true в случае успешного удаления, иначе false.
     */
    @Override
    public boolean delete(String id) {
        boolean result = false;
        if (mem.containsKey(id)) {
            mem.remove(id);
            result = true;
        }
        return result;
    }

    /**
     * Поиск элемента в хранилище по id.
     *
     * @param id Идентификатор искомого элемента.
     * @return вернуть объект элемента
     */
    @Override
    public T findById(String id) {
        return mem.get(id);
    }
}
