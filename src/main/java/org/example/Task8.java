package org.example;

import java.util.Arrays;

/***
 * Найти медиану в массиве вещественных чисел. Для вычисления медианы
 * следует упорядочить по возрастанию и, в случае нечетного количества членов,
 * взять средний элемент, а в случае четного количества членов взять среднее
 * арифметическое между двумя "средними" членами.
 */
public class Task8 {
    public static void main(String[] args) {
        double[] test1 = new double[]{1.5, 3.2, 2.7, 4.1, 2.9};
        double[] test2 = new double[]{1.5, 3.2, 2.7, 4.1};
        System.out.println(findMedianInRealArr(test1));
        System.out.println(findMedianInRealArr(test2));
    }
    public static double findMedianInRealArr(double[] arr) {
        Arrays.sort(arr);
        int i = (arr.length - 1) / 2;
        return arr.length % 2 == 0 ? (arr[i] + arr[i + 1]) / 2 : arr[i];
    }
}
