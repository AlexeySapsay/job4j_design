package ru.job4j.generics;

import java.util.*;

public class GenericUsage {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        //list.add(new Person("name", 21, new Date(913716000000L)));
        List<? super Integer> list1 = new ArrayList<>();
        new GenericUsage().addAll(list1);
    }

    public void printRsl(Collection<?> col) {
        for (Iterator<?> it = col.iterator();
                it.hasNext();) {
            Object next = it.next();
            System.out.println(next);
        }
    }

    @SuppressWarnings("checkstyle:EmptyForIteratorPad")
    public void printInfo(Collection<? extends Person> col) {
        for (Iterator<? extends Person> it = col.iterator();
             it.hasNext();) {
            Person next = it.next();
            System.out.println(next);
        }
    }

    public void addAll(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        for (Object o : list) {
            System.out.println("Текущий элемент: " + o);
        }
    }
}
