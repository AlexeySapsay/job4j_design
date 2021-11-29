package ru.job4j.tdd;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class CinemaTest {
    /**
     * @Test
     *     public void buy() {
     *         Account account = new AccountCinema();
     *         Cinema cinema = new Cinema3D();
     *         Calendar date = Calendar.getInstance();
     *         date.set(2020, 10, 10, 23, 00);
     *         Ticket ticket = cinema.buy(account, 1, 1, date);
     *         assertThat(ticket, is(new Ticket3D()));
     *     }
     *
     *     @Test
     *     public void find() {
     *         Cinema cinema = new Cinema3D();
     *         cinema.add(new Session3D());
     *         List<Session> sessions = cinema.find(session -> true);
     *         assertThat(sessions, is(Arrays.asList(new Session3D())));
     *     }
     *
     *     @Test
     *     public void buyTiketAtTheSamePlace() {
     *         Account account1 = new AccountCinema();
     *         Account account2 = new AccountCinema();
     *         List<Ticket> ticketList = new ArrayList<>();
     *
     *         Cinema cinema = new Cinema3D();
     *         Calendar date = Calendar.getInstance();
     *
     *         date.set(2020, 10, 10, 23, 00);
     *         Ticket ticket1 = cinema.buy(account1, 1, 1, date);
     *         Ticket ticket2 = cinema.buy(account2, 1, 1, date);
     *         ticketList.add(ticket1);
     *         ticketList.add(ticket2);
     *         cinema.findTiket(ticket -> true);
     *
     *         //assertThat(ticket1, is(Arrays.asList(ticketList)));
     *         assertTrue(ticket1.equals(ticket2));
     *
     *         //assertEquals(ticket1, ticket2);
     *     }
     */

}