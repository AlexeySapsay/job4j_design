package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;


    public static void main(String[] args) {
//        int[][] data = new int[][]{{1, 2, 3, 4},
//                {5, 6, 7, 8}};
//        int[][] data = new int[][]{{1, 2},
//                {3, 4}};
//        int[][] data = new int[][]{{1, 2},
//                {3, 4, 5, 6, 7}, {}, {0, 0, 0, 1}};
        int[][] data = new int[][]{{1, 2, 3}, {0}};

//        for (int row = 0; row < data.length; row++) {
//            for (int column = 0; column < data[row].length; column++) {
//                //System.out.println(data[row][col]);
//                //System.out.println((Integer) data[row][col]);
//                MatrixIt it = new MatrixIt(data);
//                //System.out.println((Integer) it.next());
//                System.out.println(it.next());
//            }
//        }
        MatrixIt it = new MatrixIt(data);
        for (int row = 0; row < data.length; row++) {
            for (int column = 0; column < data[row].length; column++) {
                //System.out.println(data[row][col]);
                //System.out.println((Integer) data[row][col]);
                //MatrixIt it = new MatrixIt(data);
                //System.out.println((Integer) it.next());
                System.out.println(it.next());
            }
        }
    }

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return data[row][column] < data.length;
    }

    @Override
    public Integer next() {
//        if (!hasNext()) {
//            //throw new NoSuchElementException();
//        }
//        int bufferData = data[row][column];
//        while(){
//
//        }
        //return data[row][column];

//        for (int row = 0; row < arrWay.length; row++) {
//            for (int col = 0; col < arrWay[row].length; col++) {
//                System.out.println(arrWay[row][col]);
//            }
//        }
        //MatrixIt it = new MatrixIt(data);

//        for (int row = 0; row < data.length; row++) {
//            for (int column = 0; column < data[row].length; column++) {
//                //System.out.println(data[row][col]);
//                //System.out.println((Integer) data[row][col]);
//
//                //System.out.println((Integer) it.next());
//                //System.out.println(it.next());
//                return data[row][column];
//            }
//        }
        if (row < data.length) {
            row++;
        } else if (column < data[row].length) {
            column++;
        } else {
            return data[row][column];
        }

        return data[row][column];
    }
}
