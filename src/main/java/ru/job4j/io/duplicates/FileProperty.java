package ru.job4j.io.duplicates;

import java.util.Objects;

/**
 * https://job4j.ru/profile/exercise/45/task-view/315
 * <p>
 * Нужно написать программу, которая принимает на вход
 * папку, просматривает все файлы в ней (и всех подпапках
 * и под-под-...папках) и сообщает, если находит дубликаты.
 * Дубликаты – это два файла с одинаковым именем и размером.
 * <p>
 * Данный класс представляет собой модель данных.
 * Модель данных
 * Для решения данной задачи нам нужно выделить модель данных файла,
 * которая описывается двумя свойствами: размером и именем.
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 06.09.2021
 */
public class FileProperty {
    private long size;
    private String name;

    public FileProperty(long size, String name) {
        this.size = size;
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        // здесь переопределение equals начинает отличаться от
        // описанного в задании
        // переписал из задания
        FileProperty that = (FileProperty) o;
        return size == that.size && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
//        int result = (int) (size ^ (size >>> 32));
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        return result;
        //хэшкод так же отличается от задания
        return Objects.hash(size, name);
    }

    @Override
    public String toString() {
        return "FileProperty{"
                + "size=" + size
                + ", name='" + name + '\''
                + '}';
    }
}
