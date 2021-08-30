package ru.job4j.collection;

import java.util.*;

public class MainUser {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        User user1 = new User("Alex", 0, calendar);
        User user2 = new User("Alex", 0, calendar);


        Map<User, Object> map = new HashMap<User, Object>();
        map.put(user1, new Object());
        map.put(user2, new Object());

//        Iterator<Map.Entry<User, Object>> iter = map.entrySet().iterator();
//        while (iter.hasNext()) {
//            Map.Entry<User, Object> entry = iter.next();
//            System.out.println("Key = " + entry.getKey()
//                    + ", Value = " + entry.getValue()
//                    + ", Object's hashCode is: " + hash(entry.getKey()));
//        }

//        System.out.println(user1.hashCode() + " User1 hashCode");
//        System.out.println(user2.hashCode() + " User2 hashCode");

        int hk1 = 5;
        int hk2 = 31;

        int length = 16;
//        System.out.println(hk1 % length);
//        System.out.println(hk2 % length);

//        System.out.println("equals from objects is "
//                + Objects.equals(null, null));
//
//        HashMap<String, String> map1 = new HashMap<>();
        //System.out.println(("null").hashCode());

//        int capacity = 8;
//        for (int i = 0; i < 10; i++) {
//            capacity = capacity * 2;
//            System.out.println(capacity);
//        }

    }
}
