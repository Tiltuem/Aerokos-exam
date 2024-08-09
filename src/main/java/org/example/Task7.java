package org.example;

/*
Найти среднее арифметическое всex элементов,
находящихся одновременно слева от побочной и главной диагонали целочисленной квадратной матрицы (включаая диагонали).
*/
public class Task7 {
    public static void main(String[] args) {
        // 1, 5, 6, 9, 10, 13
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        // 1, 5, 6, 9, 10, 11, 13, 14, 17
        int[][] matrix2 = {
                {1, 2, 3, 4, 0},
                {5, 6, 7, 8, 0},
                {9, 10, 11, 12, 0},
                {13, 14, 15, 16, 0},
                {17, 18, 19, 20, 0}};

        // 1, 5, 6, 9, 10, 11, 13, 14, 15, 13, 14, 17
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
        int row = 0, column = 0, temp = 0, length = matrix.length;

        while (row < length) {
            while (column <= temp) {
                sum += matrix[row][column];
                System.out.println(matrix[row][column]);
                count++;
                column++;
            }
            row++;
            column = 0;
            temp = row < length / 2 ? row : length - row - 1;
        }

        return count == 0 ? 0 : sum / count;
    }
}
