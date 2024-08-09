package org.example;

/**
 * Найти индекс начала наиболее длинной непрерывной последовательности
 * одинаковых чисел в целочисленном массиве
 */

public class Task5 {
    public static void main(String[] args) {
        int[] test = new int[]{1, 4, 7, 3, 3, 3, 3, 1, 4, 2, 2, 2, 2};
        System.out.println(findIndexOfHighestSeq(test));
    }
    public static int findIndexOfHighestSeq(int[] data) {
        int counter = 0;
        int result = 0;
        int maxSeq = Integer.MIN_VALUE;
        int i;
        for (i = 1; i != data.length; i++) {
            if (data[i] == data[i - 1]) {
                counter++;
            } else {
                if (counter + 1 > maxSeq && counter + 1 >= 2) {
                    counter++;
                    maxSeq = counter;
                    result = i - counter;
                    counter = 0;
                }
            }
        }
        if (counter + 1 > maxSeq && counter + 1 >= 2) {
            counter++;
            maxSeq = counter;
            result = i - counter;
            counter = 0;
        }

        return result;
    }
}
