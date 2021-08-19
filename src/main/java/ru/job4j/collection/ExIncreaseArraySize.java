package ru.job4j.collection;

import java.util.Arrays;
/**
 * Динамический массив. Аналог ArrayList
 * проверка корректности увеличения размера массива+1,
 * при исчерпании свободного места.
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 0.1
 * @since 18.08.2021
 */
public class ExIncreaseArraySize {
    public static void main(String[] args) {
        int[] arrayInt = new int[2];
        int counter = 0;

        for (int i = 0; i < 10; i++) {
            if (arrayInt.length <= counter) {
                //int[] bufferArray = new int[arrayInt.length + 1];
                int[] bufferArray = Arrays.copyOf(arrayInt, arrayInt.length + 1);
                //bufferArray = arrayInt;
                System.out.println("bufferArray length after resize:" + bufferArray.length);
                arrayInt = Arrays.copyOf(bufferArray, bufferArray.length);
                //arrayInt = new int[arrayInt.length + 1];
                System.out.println(" arrayInt length after resize:" + arrayInt.length);
                arrayInt[counter++] = i;
            } else {
                arrayInt[counter++] = i;
                //System.out.println("buffer array length after resize:" + bufferArray.length);
                //arrayInt = new int[arrayInt.length + 1];
                System.out.println("buffer array length :" + arrayInt.length);
            }
        }
        for (int i = 0; i < arrayInt.length; i++) {
            System.out.print(arrayInt[i] + " ");
        }
        //System.out.println("arrayInt:" + arrayInt.toString());
    }
}
