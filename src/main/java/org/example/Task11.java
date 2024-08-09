package org.example;

/**
 * Найти среднее арифметическое всex элементов,
 * находящихся над побочной и главной диагонали целочисленной квадратной матрицы.
 */

public class Task11 {
    public static void main(String[] args) {
        // 2, 3
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        // 2, 3, 4, 7
        int[][] matrix2 = {
                {1, 2, 3, 4, 0},
                {5, 6, 7, 8, 0},
                {9, 10, 11, 12, 0},
                {13, 14, 15, 16, 0},
                {17, 18, 19, 20, 0}};

        // 2, 3, 4, 0, 7, 8
        int[][] matrix3 = {
                {1, 2, 3, 4, 0, 0},
                {5, 6, 7, 8, 0, 0},
                {9, 10, 11, 12, 0, 0},
                {13, 14, 15, 16, 0, 0},
                {13, 14, 15, 16, 0, 0},
                {17, 18, 19, 20, 0, 0}};

        System.out.println(averageLeftOfDiagonals(matrix3));
    }


    public static double averageLeftOfDiagonals(int[][] matrix) {
        double sum = 0;
        int count = 0;
        int row = 0, column = 1, length = matrix.length;
        while (row < length) {
            while (column < length - row - 1) {
                sum += matrix[row][column];
                System.out.println(matrix[row][column]);
                count++;
                column++;
            }
            row++;
            column = row + 1;
        }

        return count == 0 ? 0 : sum / count;
    }
}
