package ru.job4j.generics;

public class ForTest {
    public static void main(String[] args) {
        Object[] arr = new Object[4];
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        arr[0] = new Object();
        arr[2] = new Object();

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
