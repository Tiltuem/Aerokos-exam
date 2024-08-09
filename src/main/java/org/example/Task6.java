package org.example;

/**
 * Найти среднее арифметическое всex элементов,
 * находящихся одновременно под побочной и главной диагонали целочисленной квадратной матрицы.
 */
public class Task6 {
    public static void main(String[] args) {
        // 14, 15
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        // 18, 19, 20, 15
        int[][] matrix2 = {
                {1, 2, 3, 4, 0},
                {5, 6, 7, 8, 0},
                {9, 10, 11, 12, 0},
                {13, 14, 15, 16, 0},
                {17, 18, 19, 20, 0}};

        //18, 19, 20, 0, 15, 16
        int[][] matrix3 = {
                {1, 2, 3, 4, 0, 0},
                {5, 6, 7, 8, 0, 0},
                {9, 10, 11, 12, 0, 0},
                {13, 14, 15, 16, 0, 0},
                {13, 14, 15, 16, 0, 0},
                {17, 18, 19, 20, 0, 0}};

        System.out.println(averageLeftOfDiagonals(matrix));
    }


    public static double averageLeftOfDiagonals(int[][] matrix) {
        double sum = 0;
        int count = 0;
        int row = matrix.length - 1, column = 1, length = matrix.length;

        while (row > 0) {
            while (column < row) {
                sum += matrix[row][column];
                System.out.println(matrix[row][column]);
                count++;
                column++;
            }
            row--;
            column = length - row ;
        }

        return count == 0 ? 0 : sum / count;
    }
}
