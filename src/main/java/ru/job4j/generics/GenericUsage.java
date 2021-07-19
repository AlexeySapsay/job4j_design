package ru.job4j.generics;

import java.util.*;

import ru.job4j.generics.Person;

public class GenericUsage {
    public static void main(String[] args) {
        //List<String> list = new ArrayList<>();
        List list = new ArrayList();
        list.add("first");
        list.add("second");
        list.add("third");
        //list.add(new Person("Alex", 32, new Date(913716000000L)), 1);
        list.add(new Person("name", 21, new Date(913716000000L)));
        //String s1 = list.get(1);
//        for (String s : list) {
//            System.out.println("Текущий элемент: " + s);
//        }
//        for (int i = 0; i < list.size(); i++) {
//            String s = (String) list.get(i);
//            System.out.println("Current element: " + s);
//       }

//        List<Integer> l = List.of(1, 2, 3, 4, 5);
//        new GenericUsage().printRsl(l);
//
//        List<Person> per = List.of(new Person("name", 21, new Date(913716000000L)));
//        new GenericUsage().printRsl(per);
//
//        List<Programmer> pro = List.of(new Programmer("name123", 23, new Date(913716000000L)));
//        //new GenericUsage().printRsl(pro);
//        new GenericUsage().printInfo(pro);

        List<? super Integer> list1 = new ArrayList<>();
        new GenericUsage().addAll(list1);
    }

    //    public void printRsl(Collection<Object> col) {
//        for (Iterator<Object> it = col.iterator();
//             it.hasNext(); ) {
//            Object next = it.next();
//            System.out.println(next);
//        }
//    }
    @SuppressWarnings("checkstyle:EmptyForIteratorPad")
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
