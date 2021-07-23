package ru.job4j.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * SimpleArray is an implementation of not dynamic ArrayList
 *
 * @param <T> - data tape of element
 */
public class SimpleArray<T> implements Iterable<T> {
    private Object[] objArray;
    public final int length;
    private int size;

    // class constructor
    public SimpleArray(int length) {
        this.length = length;
        objArray = new Object[length];
    }

    /**
     * adds element @model to an first empty baket array
     *
     * @param model
     */
    public void add(T model) {
        if (objArray.length == size) {
            throw new IndexOutOfBoundsException();
        } else {
            // looking for an empty baket for element
            // by iterator or algorithm?
            int isEmptyBaket = 0;
            while (isEmptyBaket < objArray.length
                    && objArray[isEmptyBaket] != null) {
                isEmptyBaket++;
            }
            if (objArray[isEmptyBaket] != null) {
                throw new IndexOutOfBoundsException();
            }
            objArray[isEmptyBaket] = model;
            size++;
        }
    }

    /**
     * Set an element to the specific position in the array where
     *
     * @param index index of position
     * @param model lement to set
     * @throws IndexOutOfBoundsException
     */
    public void set(int index, T model) throws IndexOutOfBoundsException {
        Objects.checkIndex(index, objArray.length);
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
        Objects.checkIndex(index, objArray.length);

        Object[] objArrayBuff1 = Arrays.copyOf(objArray, index);
        Object[] objArrayBuff2 = Arrays.copyOfRange(objArray, index + 1, length);
        Object[] resultArray = Arrays.copyOf(objArrayBuff1,
                objArrayBuff1.length + objArrayBuff2.length);
        System.arraycopy(objArrayBuff2, 0, resultArray,
                objArrayBuff1.length, objArrayBuff2.length);
        objArray = resultArray;
    }

    /**
     * get(int index) - возвращает элемент, расположенный по указанному индексу;
     *
     * @param index - take element by that index
     * @return - element by Index from (T) objArray[index]
     * @throws IndexOutOfBoundsException
     */
    public T get(int index) throws IndexOutOfBoundsException {
        Objects.checkIndex(index, objArray.length);
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
                return valueIteration < length;
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

        if (length != that.length) {
            return false;
        }
        return Arrays.equals(objArray, that.objArray);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(objArray);
        result = 31 * result + length;
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(objArray);
    }
}
