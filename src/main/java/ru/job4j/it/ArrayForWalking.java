package ru.job4j.it;

public class ArrayForWalking {
    public static void main(String[] args) {
//        int[][] arrWay = new int[][]{{1, 2, 3, 4},
//                {5, 6, 7, 8}};
//        int[][] arrWay = new int[][]{{1, 2},
//                {3, 4}};
        int[][] arrWay = new int[][]{{1, 2},
                {3, 4, 5, 6, 7}, {}, {0, 0, 0, 1}};

        for (int row = 0; row < arrWay.length; row++) {
            for (int col = 0; col < arrWay[row].length; col++) {
                System.out.println(arrWay[row][col]);
            }
        }
    }
}
