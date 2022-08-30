package ru.job4j.tdd;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class Cinema3D implements Cinema {
    public static final int SIZEOFCINEMA = 100;
    public static int emptyPlace = 100;

    public List<Account> accountList = new ArrayList<>();


    @Override
    public List<Session> find(Predicate<Session> filter) {
        return null;
    }

    @Override
    public List<Ticket> findTicket(Predicate<Ticket> filter) {
        return null;
    }

    @Override
    public Ticket buy(Account account, int row, int column, Calendar date) {
        return null;
    }

    @Override
    public void add(Session session) {

    }
}
