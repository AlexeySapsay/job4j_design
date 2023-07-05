package ru.job4j.collection;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class MainUser {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        User user1 = new User("Alex", 0, calendar);
        User user2 = new User("Alex", 0, calendar);


        Map<User, Object> map = new HashMap<User, Object>();
        map.put(user1, new Object());
        map.put(user2, new Object());

        int hk1 = 5;
        int hk2 = 31;

        int length = 16;

    }
}
