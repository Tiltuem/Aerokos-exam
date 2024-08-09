package org.example;

/**
 * Найти индекс начала наиболее короткой (не менее двух) и непрерывной последовательности
 * одинаковых чисел в целочисленном массиве
 */

public class Task1 {
    public static void main(String[] args) {
        int[] test = new int[]{1, 4, 7, 3, 3, 3, 3, 2, 2, 1, 1};
        System.out.println(findIndexOfLowestSeq(test));
    }

    public static int findIndexOfLowestSeq(int[] data) {
        int counter = 0;
        int result = 0;
        int minSeq = Integer.MAX_VALUE;
        int i;
        for (i = 1; i != data.length; i++) {
            if (data[i] == data[i - 1]) {
                counter++;
            } else {
                if (counter + 1 < minSeq && counter + 1 >= 2) {
                    counter++;
                    minSeq = counter;
                    result = i - counter;
                    counter = 0;
                }
            }
        }
        if (counter + 1 < minSeq && counter + 1 >= 2) {
            counter++;
            minSeq = counter;
            result = i - counter;
            counter = 0;
        }

        return result;
    }
}
