package ru.job4j.map;

import java.util.*;

/**
 * // https://www.geeksforgeeks.org/internal-working-of-hashmap-java/
 * <p>
 * Класс SimpleMap для изучения работы с HashMap
 * и создание коллекции, аналога HashMap
 * {@inheritDoc}
 *
 * @param <K> Ключ
 * @param <V> Значение
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 26.08.2021
 */
public class SimpleMap<K, V> implements Map<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;           //начальное количество бакетов в коллекции при инициализации
    private int modCount = 0;           //реальное количество модификаций коллекции
    private int expectedModCount = 0;   //ожидаемое количество модификаций коллекции
    private int size = 0;               //  показывает количество занятых бакетов

    private MapEntry<K, V>[] table = new MapEntry[capacity]; // внутренний массив SimpleMap

    @Override
    public boolean put(K key, V value) {
        // проверка, на наличие свободного места для вставки элемента
        // если места не достаточно, увеличиваем размер таблицы в 2 раза
        if (capacity * LOAD_FACTOR <= size) {
            capacity = capacity * 2;
            expand();
        }

        // вычисляем хэш элемента
        // вычисляем хэш в таблице
        // определяем индекс в таблице
        int indexInMapEntry = indexFor(key.hashCode());


        //  проверяем свободна ли ячейка в table по адресу indexInTable
        //  условие(если ячейка по индексу свободна){
        //  добавляем элемент}
        //  в противном случае возвращаем фолс.

        if (table[indexInMapEntry] != null) {
            return false;
        } else {
            table[indexInMapEntry] = new MapEntry(key, value);
            modCount++;
            size++;
        }
        return true;
    }

    /**
     * Генерация хэш- функции на мой выбор
     * хэш- функция выполняет нормализацию, в распределении по бакетам
     *
     * @param hashCode хэш код , стандартная реализация из Object
     * @return хэш значение
     */
    public int hash(int hashCode) {
        //Здесь стоит сразу подчеркнуть. hash(null) всегда равно 0.
        return hashCode % (capacity - 1);
    }

    /**
     * Генерация индекса бакета
     *
     * @param hash хэш- значение
     * @return индекс бакета для объекта
     */
    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    /**
     * HashMap увеличивается в размерах в 2 раза
     * после достижения значения loadFactor * capacity.
     * Создается буфферная SimpleMap, в нее помещаются значения
     * происходит увеличение исходной таблицы в 2 раза и
     * рехеширование
     */
    private void expand() {
        // создаем буферную талицу размером первая * 2
        MapEntry<K, V>[] tableBuffer = new MapEntry[capacity]; // внутренний массив SimpleMap

        // рехешируем table и сохраняем по новым индексам в tableBuffer
        for (MapEntry mapEntry : table) {
            if (mapEntry == null) {
                continue;
            } else {
                int indexForBufferTable = indexFor(hash(mapEntry.key.hashCode()));
                tableBuffer[indexForBufferTable] = mapEntry;
            }
        }
        table = Arrays.copyOf(tableBuffer, capacity);
    }

    /**
     * Извлекает значение находящееся по ключу key
     *
     * @param key ключ для поиска пары
     * @return Метод get() в случае отсутствия значения должен
     * возвращать null, в противном случае само значение.
     */
    @Override
    public V get(K key) {
        for (MapEntry mapEntry : table) {
            if (mapEntry == (null)) {
                continue;
            }
            if (mapEntry.key.equals(key)) {
                return (V) mapEntry.value;
            }
        }
        return null;
    }

    /**
     * Метод удаляет пару ключ key и значение value по ключу key
     *
     * @param key ключ
     * @return Метод remove() в случае успешного удаления должен возвращать true,
     * в противном случае false.
     */
    @Override
    public boolean remove(K key) {
        for (MapEntry mapEntry : table) {
            if (mapEntry == (null)) {
                continue;
            }
            if (mapEntry.key.equals(key)) {
                mapEntry.key = null;
                mapEntry.value = null;
                modCount++;
                size--;
                return true;
            }
        }
        return false;
    }

    /**
     * Также, реализуйте интерфейс Iterable - метод iterator()
     * возвращает итератор, предназначенный для обхода данной структуры.
     * <p>
     * Объект должен принимать количество ячеек. Структура должна быть
     * динамической.
     * Итератор должен обладать fail-fast поведением
     *
     * @return SimpleHashIterator
     */
    @Override
    public Iterator<K> iterator() {
        expectedModCount = modCount;

        class SimpleHashIterator implements Iterator<K> {
            int valueIterator = 0;

            @Override
            public boolean hasNext() {
                return valueIterator < size;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (K) table[size++];
            }
        }
        return new SimpleHashIterator();
    }

    /**
     * Вложенный класс, формирующий Node<K,V> по аналогии
     * с HashMap здорового человека
     *
     * @param <K> ключ
     * @param <V> значение
     */
    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public String toString() {
        return "SimpleMap{"
                + "capacity=" + capacity
                + ", modCount=" + modCount
                + ", expectedModCount=" + expectedModCount
                + ", size=" + size
                + ", table=" + Arrays.toString(table)
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SimpleMap<?, ?> simpleMap = (SimpleMap<?, ?>) o;

        if (capacity != simpleMap.capacity) {
            return false;
        }
        if (modCount != simpleMap.modCount) {
            return false;
        }
        if (expectedModCount != simpleMap.expectedModCount) {
            return false;
        }
        if (size != simpleMap.size) {
            return false;
        }
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(table, simpleMap.table);
    }

    @Override
    public int hashCode() {
        int result = capacity;
        result = 31 * result + modCount;
        result = 31 * result + expectedModCount;
        result = 31 * result + size;
        result = 31 * result + Arrays.hashCode(table);
        return result;
    }
}
