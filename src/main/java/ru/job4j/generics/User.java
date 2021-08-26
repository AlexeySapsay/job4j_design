package ru.job4j.generics;

/**
 * class User для работы в коллекции MemStore
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 0.1
 * @since 14.08.2021
 */

/**
 * {@inheritDoc}
 */
public class User extends Base {

    public User(String id) {
        super(id);
    }

    @Override
    public String getId() {
        return super.getId();
    }
}
