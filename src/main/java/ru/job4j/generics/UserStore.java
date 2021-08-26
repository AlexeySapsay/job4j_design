package ru.job4j.generics;

/**
 * class UserStore для работы в коллекции MemStore
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 0.1
 * @since 14.08.2021
 */

public class UserStore implements Store<User> {
    private final Store<User> store = new MemStore<>();

    /**
     * {@inheritDoc}
     *
     * @param model добавляемый элемент
     */
    @Override
    public void add(User model) {
        store.add(model);
    }

    /**
     * {@inheritDoc}
     *
     * @param id    Идентификатор элемента в контейнере.
     * @param model добавляемый элемент в контейнер.
     * @return true/ false
     */
    @Override
    public boolean replace(String id, User model) {
        return store.replace(id, model);
    }

    /**
     * {@inheritDoc}
     *
     * @param id идентификатор элемента.
     * @return true/ false
     */
    @Override
    public boolean delete(String id) {
        return store.delete(id);
    }

    /**
     * {@inheritDoc}
     *
     * @param id Идентификатор искомого элемента.
     * @return true/ false
     */
    @Override
    public User findById(String id) {
        return store.findById(id);
    }
}
