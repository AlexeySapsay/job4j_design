package ru.job4j.generics;

import java.util.*;

/**
 * SimpleArray is an implementation of not dynamic ArrayList
 *
 * @param <T> - data tape of element
 */
public class SimpleArray<T> implements Iterable<T> {
    private Object[] objArray;
    private int counter = 0;

    // class constructor
    public SimpleArray(int counter) {
        this.objArray = new Object[counter];
    }

    /**
     * adds element @model to an first empty baket array
     *
     * @param model
     */
    public void add(T model) {
        objArray[counter++] = model;
    }

    /**
     * Set an element to the specific position in the array where
     *
     * @param index index of position
     * @param model element to set
     * @throws IndexOutOfBoundsException
     */
    public void set(int index, T model) throws IndexOutOfBoundsException {
        Objects.checkIndex(index, counter);
        objArray[index] = model;
    }

    /**
     * remove(int index) - удаляет элемент по указанному индексу,
     * все находящиеся справа элементы при этом необходимо сдвинуть
     * на единицу влево (в середине массива не должно быть пустых ячеек);
     *
     * @param index
     * @throws IndexOutOfBoundsException
     */
    public void remove(int index) throws IndexOutOfBoundsException {
        Objects.checkIndex(index, counter);
        // закоменченный код демонстрирует утечку памяти, не удалять
        // оставить как пример для демонстрации

//        System.arraycopy(objArray, index + 1, objArray,
//                index, objArray.length - index - 1);
        //objArray[index] = null;

        System.arraycopy(objArray, index + 1, objArray,
                index, objArray.length - index - 1);
        objArray[objArray.length - index - 1] = null;
        counter--;
    }

    /**
     * get(int index) - возвращает элемент, расположенный по указанному индексу;
     *
     * @param index - take element by that index
     * @return - element by Index from (T) objArray[index]
     * @throws IndexOutOfBoundsException
     */
    public T get(int index) throws IndexOutOfBoundsException {
        Objects.checkIndex(index, counter);
        return (T) objArray[index];
    }

    /**
     * Также, реализуйте интерфейс Iterable<T> - метод iterator()
     * возвращает итератор, предназначенный для обхода данной структуры.
     * <p>
     * Объект должен принимать количество ячеек. Структура не должна быть
     * динамической.
     *
     * @return SimpleArrayIterator()
     */
    @Override
    public Iterator<T> iterator() {
        class SimpleArrayIterator implements Iterator<T> {
            int valueIteration = 0;

            @Override
            public boolean hasNext() {
                return valueIteration < counter;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) objArray[valueIteration++];
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
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(objArray, that.objArray);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(objArray);
        result = 31 * result + counter;
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(objArray);
    }

    // демонстрация утечки памяти
    //https://job4j.ru/profile/exercise/39/task-view/277
//    public static void main(String[] args) {
//        var list = new SimpleArray<Integer>(10);
//        for (var i = 1; i <= 10; i++) {
//            list.add(i);
//        }
//        System.out.println(list);
//        for (var i = 0; i < 10; i++) {
//            list.remove(0);
//        }
//        System.out.println(list);
//    }
}
