package ru.job4j.map;

import java.util.Arrays;
import java.util.Iterator;

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
    private int countExpand = 1;
    private int modCount = 0;           //реальное количество модификаций коллекции
    private int expectedModCount = 0;   //ожидаемое количество модификаций коллекции
    private int size = 0;               //  показывает количество занятых бакетов

    private MapEntry<K, V>[] table = new MapEntry[capacity]; // внутренний массив SimpleMap
    //private MapEntry<K, V>[] tableBuffer = new MapEntry[capacity * 2]; // внутренний массив SimpleMap


    @Override
    public boolean put(K key, V value) {
        //         вычисляем хэш элемента
        //         вычисляем хэш в таблице
        //         определяем индекс в таблице
        int indexInMapEntry = indexFor(key.hashCode());

        // проверка, на наличие свободного места для вставки элемента
        // если места не достаточно, увеличиваем размер таблицы в 2 раза
        if (capacity * LOAD_FACTOR <= size) {
            //countExpand *= capacity * 2;
            //countExpand = capacity * 2;
            //countExpand = capacity * 2;
            capacity = capacity * 2;
            countExpand = capacity;
            expand();
            System.out.println("table length : " + table.length);
            //continue;
        }
        System.out.println("table length : " + table.length);

        //  проверяем свободна ли ячейка в table по адресу indexInTable
        //  условие(если ячейка по индексу свободна){
        //  добавляем элемент}
        //  в противном случае возвращаем фолс.

        if (table[indexInMapEntry] != null) {
            return false;
        } else {
            table[indexInMapEntry] = new MapEntry(key, value);
            size++;
        }


        //System.out.println("Place in table is : " + table[indexInMapEntry]);
        //+ " key is: " + table[indexInMapEntry].key);
        //+ "value is : " + table[indexInMapEntry].value);
        //System.out.println("Index is : " + indexInMapEntry);

        //System.out.println("MapEntry is:" + table);

//        for (MapEntry mapEntry : table) {
//            System.out.println(mapEntry);
//            //mapEntry = new MapEntry("Alex", 10);
//        }

        // заполняем значениями, что бы проверить заполняемость и корректный вывод

//        for (MapEntry mapEntry : table) {
//            mapEntry = new MapEntry("Alex", 10);
//            System.out.println("mapEntry is : "
//                    + mapEntry.toString().substring(13, mapEntry.toString().length() - 13)
//                    + " mapEntry.key is: " + mapEntry.key
//                    + " mapEntry.value is: " + mapEntry.value);
//        }


//        System.out.println(table[indexInMapEntry].key
//                + " " + table[indexInMapEntry].value);

//        for (int i = 0; i < table.length; i++) {
//            table[i] = new MapEntry(i, i);
//            System.out.println(" key :" + table[i].key
//                    + " value :" + table[i].value);
//        }
        // вызов метода только для теста метода, удалить этот вызов в будущем
        //expand();

//        if (table[indexInMapEntry] == null) {
//            table[indexInMapEntry].key = key;
//            table[indexInMapEntry].value = value;
//
//            System.out.println("Index in table after put is : " + table[indexInMapEntry]);
//            //+ " key is: " + table[indexInMapEntry].key);
//            //+ "value is : " + table[indexInMapEntry].value);
//            System.out.println("Index after put is : " + indexInMapEntry);
//
//            return true;
//        }


        System.out.println("table.length : " + table.length);
        //для вывода
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                continue;
            }
            System.out.println(table[i].key + " " + table[i].value);
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
        //int multyplyCapacityTwo = capacity * 2;
        int multyplyCapacityTwo = countExpand;
        // создаем буферную талицу размером первая * 2
        MapEntry<K, V>[] tableBuffer = new MapEntry[multyplyCapacityTwo]; // внутренний массив SimpleMap

//        for (int i = 0; i < tableBuffer.length; i++) {
//            tableBuffer[i] = new MapEntry(i, i);
//            System.out.println(tableBuffer[i].key + " " + tableBuffer[i].value);
//        }
        for (MapEntry mapEntry : table) {
            //int indexForBufferTable = indexFor(mapEntry.key.hashCode());
            if (mapEntry == null) {
                continue;
            }
            //int i = hash()
            int indexForBufferTable = indexFor(hash(mapEntry.key.hashCode()));
            System.out.println("indexForBufferTable " + indexForBufferTable);
            tableBuffer[indexForBufferTable] = mapEntry;
        }
        System.out.println("table length : " + table.length);
        System.out.println("tableBuffer length : " + tableBuffer.length);

        for (MapEntry mapEntry : table) {
            if (mapEntry == null) {
                continue;
            }
            System.out.println("mapEntry.key : " + mapEntry.key
                    + " mapEntry.value : " + mapEntry.value);
        }

        for (MapEntry mapEntry : tableBuffer) {
            if (mapEntry == null) {
                continue;
            }
            System.out.println(" tableBuffer mapEntry.key : " + mapEntry.key
                    + " tableBuffer mapEntry.value : " + mapEntry.value);
        }
        //MapEntry<K, V>[] table = new MapEntry[capacity * 2];
        //table = tableBuffer;
        table = Arrays.copyOf(tableBuffer, multyplyCapacityTwo);

        System.out.println("table.length before : " + table.length);

        for (MapEntry mapEntry : table) {
            if (mapEntry == null) {
                continue;
            }
            System.out.println("mapEntry.key : " + mapEntry.key
                    + " mapEntry.value : " + mapEntry.value);
        }

        System.out.println("table.length after : " + table.length);

        // производим рехеширование значений из первой в буфер

        //tableBuffer;
        // увеличиваем размер первой таблицы в 2 раза
        // закидываем в нее значения из буферной

        /**
         * Как то организовать рехеширование таблицы
         * при расширении
         */
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public boolean remove(K key) {
        return false;
    }

    /**
     * Итератор должен обладать fail-fast поведением
     *
     * @return Iterator
     */
    @Override
    public Iterator<K> iterator() {
        return null;
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

    // обязательно переопределить иквал и хэшкод

}
