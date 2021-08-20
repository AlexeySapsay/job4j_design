package ru.job4j.collection;

import java.util.*;

/**
 * Динамический список на массиве. Аналог ArrayList
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 0.1
 * @since 18.08.2021
 */

public class SimpleArray<T> implements Iterable<T> {
    private Object[] objArray;
    private int counter = 0;
    private int modCount = 0;
    private int expectedModCount = 0;

    public SimpleArray() {
        this.objArray = new Object[2];
    }

    public SimpleArray(int size) {
        this.objArray = new Object[size];
    }

    /**
     * Получение элемента по индексу
     *
     * @param index индекс элемента для извлечения из коллекции
     * @return возвращаемый элемент
     */
    public T get(int index) {
        Objects.checkIndex(index, counter);
        return (T) objArray[index];
    }

    /**
     * Добавляем элемент в динамический массив
     *
     * @param model добавляемый элемент
     */
    public void add(T model) {
        if (objArray.length <= counter) {
            objArray = Arrays.copyOf(objArray, objArray.length * 2);
        }
        objArray[counter++] = model;
        modCount += 1;
    }

    /**
     * Вставка элемента model по указанному индексу index
     *
     * @param index индекс, позиция для вставки
     * @param model элемент для вставки
     */
    public void set(int index, T model) {
        Objects.checkIndex(index, counter);
        objArray[index] = model;
        modCount += 1;
    }

    /**
     * Удаление элемента по индексу
     * remove(int index) - удаляет элемент по указанному индексу,
     * все находящиеся справа элементы при этом необходимо сдвинуть
     * на единицу влево (в середине массива не должно быть пустых ячеек).
     * И так же занулить освободившуюся крайнюю левую ячейку,
     * предотвращая утечку памяти.
     *
     * @param index индекс удаляемого элемента
     */
    public void remove(int index) {
        Objects.checkIndex(index, counter);
        System.arraycopy(objArray, index + 1, objArray,
                index, objArray.length - index - 1);
        objArray[objArray.length - index - 1] = null;
        counter--;
        modCount += 1;
    }

    /**
     * Также, реализуйте интерфейс Iterable<T> - метод iterator()
     * возвращает итератор, предназначенный для обхода данной структуры.
     * <p>
     * Объект должен принимать количество ячеек. Структура должна быть
     * динамической.
     *
     * @return SimpleArrayIterator()
     */
    @Override
    public Iterator<T> iterator() {
        expectedModCount = modCount;

        class SimpleArrayIterator implements Iterator<T> {
            int valueIterator = 0;

            @Override
            public boolean hasNext() {
                return valueIterator < counter;
            }

            @Override
            public T next() {

                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) objArray[valueIterator++];
            }
        }
        return new SimpleArrayIterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SimpleArray<?> that = (SimpleArray<?>) o;

        if (counter != that.counter) {
            return false;
        }
        if (modCount != that.modCount) {
            return false;
        }
        if (expectedModCount != that.expectedModCount) {
            return false;
        }
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(objArray, that.objArray);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(objArray);
        result = 31 * result + counter;
        result = 31 * result + modCount;
        result = 31 * result + expectedModCount;
        return result;
    }

    @Override
    public String toString() {
        return "SimpleArray{"
                + "objArray=" + Arrays.toString(objArray)
                + ", counter=" + counter
                + ", modCount=" + modCount
                + ", expectedModCount=" + expectedModCount
                + '}';
    }


//    public static void main(String[] args) {
//        var list = new SimpleArray<Integer>();
//        System.out.println(list);
//        for (var i = 0; i <= 10; i++) {
//            list.add(i);
//        }
//        System.out.println(list);
//        for (var i = 0; i < 10; i++) {
//            list.remove(0);
//        }
//        System.out.println(list);
//    }
}
