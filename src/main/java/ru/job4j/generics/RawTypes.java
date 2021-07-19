package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public class RawTypes {
    public static void main(String[] args) {
        List rawList = new ArrayList();
        List<String> list = new ArrayList<>();

        rawList = list;
        //rawList.add(0, 1);
        rawList.add(3);
        //rawList.add("string");
        //System.out.println(rawList);
        String s = list.get(0);
        System.out.println(s);
    }
}
