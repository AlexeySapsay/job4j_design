package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

/**
 * https://job4j.ru/profile/exercise/63/task-view/379
 * Это задание сводится к определению разницы между
 * начальным и измененным состояниями множества.
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 25.11.2021
 */

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return calculate(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return calculate(value, comparator.reversed());
    }

    private <T> T calculate(List<T> value, Comparator<T> comparator) {
        T result = value.get(0);
        for (T element : value) {
            if (comparator.compare(result, element) < 0) {
                result = element;
            }
        }
        return result;
    }
}

