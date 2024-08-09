package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Разбить массив целых положительных
 * чисел на два массива так, чтобы разность суммы
 * элементов двух получившихся массивов была мнимальна
 */

public class Task15 {
    public static void main(String[] args) {
        int[] arr = {7, 5, 8, 8, 1, 5, 7, 10};
        int[] arr2 = {7, 5, 8, 8, 7, 5};
        int[] arr3= {7, 5};
        int[] arr4= {1,2,3,4, 100};

        minDiffSubArray(arr4);
    }


    public static void minDiffSubArray(int[] arr) {
        if (arr.length < 2) {
            return;
        }

        double sum = Arrays.stream(arr).sum(), curSum = 0, difference = Double.MAX_VALUE, curDifference;
        int index = 0;

        for (int num : arr) {
            curSum += num;
            curDifference = Math.abs(1 - (sum - curSum) / curSum);

            if (difference < curDifference) {
                break;
            }

            difference = curDifference;
            index++;
        }

        if (index == arr.length) {
            index--;
        }

        int[] firstArr = Arrays.copyOfRange(arr, 0, index);
        int[] secondArr = Arrays.copyOfRange(arr, index, arr.length);

        System.out.println(Arrays.toString(firstArr));
        System.out.println(Arrays.toString(secondArr));
        System.out.println( Math.abs(Arrays.stream(firstArr).sum() - Arrays.stream(secondArr).sum()));
    }
}
