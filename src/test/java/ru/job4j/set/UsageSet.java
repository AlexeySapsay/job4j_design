package ru.job4j.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UsageSet {
    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        strings.addAll(List.of("one", "four", "five"));
//        for (String s : strings) {
//            System.out.println("Текущий элемент: " + s);
//        }
//        Iterator<String> it = strings.iterator();
//        while (it.hasNext()) {
//            System.out.println("Current element: " + it.next());
//        }

//        strings.remove("two");
//        System.out.println("Вывод в консоль после удаления...");
//        for (String s : strings) {
//            System.out.println("Текущий элемент: " + s);
//
//        }

//        strings.removeAll(List.of("two", "three"));
//        System.out.println("Вывод в консоль после удаления...");
//        for (String s : strings) {
//            System.out.println("Текущий элемент: " + s);
//        }

        strings.retainAll(List.of("one"));
        System.out.println("Вывод в консоль после удаления...");
        for (String s : strings) {
            System.out.println("Текущий элемент: " + s);
        }
    }
}
