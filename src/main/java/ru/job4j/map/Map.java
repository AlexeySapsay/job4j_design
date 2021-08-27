package ru.job4j.map;
/**
 * Интерейс Map для изучения работы с HashMap
 * и создание коллекции, аналога HashMap
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 26.08.2021
 */

public interface Map<K, V> extends Iterable<K> {
    /**
     * Вставка элемента с ключем key и значением value
     * Разрешение коллизий реализовывать НЕ нужно.
     * Метод вставки в случае отсутствия места должен
     * возвращать false.
     * @param key ключ объекта для вставки
     * @param value значение объекта для вставки
     * @return Метод вставки в случае отсутствия места должен
     *  возвращать false. В успешном случае возвращает true.
     */
    boolean put(K key, V value);

    /**
     * Извлекает значение находящееся по ключу key
     * @param key ключ для поиска пары
     * @return Метод get() в случае отсутствия значения должен
     * возвращать null, в противном случае само значение.
     */
    V get(K key);

    /**
     * Удаление пары key, value по ключу
     * @param key ключ
     * @return Метод remove() в случае успешного удаления должен возвращать true,
     * в противном случае false.
     */
    boolean remove(K key);
}
