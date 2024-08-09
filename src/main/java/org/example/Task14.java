package org.example;

import java.util.*;

/**
 * Найти самую длинную неубыаающую последовательность целых
 * чисел (последовательность необязвтельно должна быть непрерывной)
 */
public class Task14 {
    public static void main(String[] args) {
        int[] test = new int[]{1, 3, 5, 2, 4, 5};
        System.out.println(findLargestSeq(test));
    }
    public static List<Integer> findLargestSeq(int[] data) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i != data.length; i++) {
            for (int j = i; j != data.length; j++) {
                int index = getIndexOfMinEl(Arrays.copyOfRange(data, j, data.length));
                index += j;
                temp.add(data[index]);
                j = index;
            }
            map.put(temp.size(), new ArrayList<>(temp));
            temp.clear();
        }

        return map.get(map.lastKey());
    }

    public static int getIndexOfMinEl(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1; // Обработка пустого или null массива
        }

        int minIndex = 0; // Предполагаем, что первый элемент минимальный
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}
