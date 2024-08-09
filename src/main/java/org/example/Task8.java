package org.example;

import java.util.Arrays;

/**
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
        //Arrays.sort(arr); Можно использовать, лучше уточнить
        quickSort(arr, 0, arr.length - 1);
        int i = (arr.length - 1) / 2;
        return arr.length % 2 == 0 ? (arr[i] + arr[i + 1]) / 2 : arr[i];
    }

    public static void quickSort(double[] arr, int low, int high) {
        if (low < high) {
            // Находим индекс опорного элемента
            int pi = partition(arr, low, high);

            // Рекурсивно сортируем подмассивы
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(double[] arr, int low, int high) {
        // Выбираем последний элемент в качестве опорного
        double pivot = arr[high];

        // Индекс большего элемента
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            // Если текущий элемент меньше или равен опорному
            if (arr[j] <= pivot) {
                i++;

                // Меняем местами элементы arr[i] и arr[j]
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Меняем местами опорный элемент и элемент на позиции i+1
        double temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
