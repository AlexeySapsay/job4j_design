package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public class RawTypes {
    public static void main(String[] args) {
        List rawList = new ArrayList();
        List<String> list = new ArrayList<>();

        rawList = list;
        rawList.add(3);
        String s = list.get(0);
        System.out.println(s);
    }
}
