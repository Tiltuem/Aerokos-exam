package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * разбить массив целых положительных
 * чисел на два массива так, чтобы разность суммы
 * элементов двух получившихся массивов была мнимальна
 */

public class Task15 {
    public static void main(String[] args) {
        int[] arr = { 7,5,8,5,7 };
        Arrays.sort(arr);
        minDiffSubArray(arr);
    }
    public static void minDiffSubArray(int[] arr)
    {
        int n = arr.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        int[] arr1 = new int[n];
        arr1[0] =  arr[0];
        Map<Integer, int[]> res1 = new HashMap<>();
        for (int i = 1, i1 = 1; i < n; i++) {
            arr1[i1++] = arr[i];
            prefixSum[i]
                    = prefixSum[i - 1] + arr[i];
            res1.put(prefixSum[i], arr1.clone());
        }

        int[] suffixSum = new int[n];
        suffixSum[n - 1] = arr[n - 1];
        int[] arr2 = new int[n];
        arr2[0] = arr[n - 1];
        Map<Integer, int[]> res2 = new HashMap<>();
        for (int i = n - 2, i2 = 1; i >= 0; i--) {
            arr2[i2++] = arr[i];
            suffixSum[i]
                    = suffixSum[i + 1] + arr[i];
            res2.put(suffixSum[i], arr2.clone());
        }

        int minDiff = Integer.MAX_VALUE;
        int minPref = 0;
        int minSuff = 0;
        for (int i = 0; i < n - 1; i++) {
            int diff
                    = Math.abs(prefixSum[i]
                    - suffixSum[i + 1]);

            if (diff < minDiff) {
                minPref = prefixSum[i];
                minSuff = suffixSum[i + 1];
                minDiff = diff;
            }
        }


        System.out.println(minDiff);
        System.out.println(Arrays.toString(res1.get(minPref)));
        System.out.println(Arrays.toString(res2.get(minSuff)));

    }
}
