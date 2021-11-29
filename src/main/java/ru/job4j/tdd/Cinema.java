package ru.job4j.tdd;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

/**
 * https://job4j.ru/profile/exercise/63/task-view/380
 * Это задание сводится к определению разницы между
 * начальным и измененным состояниями множества.
 *
 * 4. Интерфейс кинотеатра - ru.job4j.tdd.Cinema.
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 29.11.2021
 */

public interface Cinema {
    List<Session> find(Predicate<Session> filter);

    List<Ticket> findTiket(Predicate<Ticket> filter);

    Ticket buy(Account account, int row, int column, Calendar date);

    void add(Session session);


}