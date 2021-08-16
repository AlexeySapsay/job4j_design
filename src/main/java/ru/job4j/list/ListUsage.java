package ru.job4j.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Изучение работы с ArrayList and LinkedList
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 0.1
 * @since 16.08.2021
 */

//https://job4j.ru/profile/exercise/4/task-view/279


public class ListUsage {
    public static void main(String[] args) {
        List<String> rsl = new ArrayList<>();
        rsl.add("one");
        rsl.add("two");
        rsl.add("three");
        List<String> list = new ArrayList<>();
        list.add("four");
        list.add("five");

        rsl.addAll(list);

//        for (String s : rsl) {
//            System.out.println("Текущий элемент: " + s);
//        }

//        for (int i = 0; i < rsl.size(); i++) {
//            System.out.println("Текущий элемент: " + rsl.get(i));
//        }
        rsl.replaceAll(String::toUpperCase);

        Iterator<String> iterator = rsl.iterator();
        while (iterator.hasNext()) {
            System.out.println("Текущий элемент: " + iterator.next());
        }

    }
}