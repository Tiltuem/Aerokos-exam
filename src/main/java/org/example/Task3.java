package org.example;

/*
Найти среднее арифметическое всex элементов,
находящихся одновременно справа от побочной и главной диагонали целочисленной квадратной матрицы (включаая диагонали).
*/
public class Task3 {
    public static void main(String[] args) {
        // 4, 7, 8, 11, 12, 16
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        // 4, 8, 8, 11, 12, 12, 16, 16, 20
        int[][] matrix2 = {
                {1, 2, 3, 4, 4},
                {5, 6, 7, 8, 8},
                {9, 10, 11, 12, 12},
                {13, 14, 15, 16, 16},
                {17, 18, 19, 20, 20}};

        // 5, 8, 9, 12, 12, 13, 16, 16, 17, 16, 17, 20
        int[][] matrix3 = {
                {1, 2, 3, 4, 4, 5},
                {5, 6, 7, 8, 8, 9},
                {9, 10, 11, 12, 12, 13},
                {13, 14, 15, 16, 16, 17},
                {13, 14, 15, 16, 16, 17},
                {17, 18, 19, 20, 20, 20}};

        System.out.println(averageLeftOfDiagonals(matrix3));
    }


    public static double averageLeftOfDiagonals(int[][] matrix) {
        double sum = 0;
        int count = 0;
        int row = 0, column = matrix.length - 1, temp = matrix.length - 1, length = matrix.length;

        while (row < length) {
            while (column >= temp) {
                sum += matrix[row][column];
                System.out.println(matrix[row][column]);
                count++;
                column--;
            }
            row++;
            column = length - 1;
            temp = row < length / 2 ? length - row - 1 : row;
        }

        return count == 0 ? 0 : sum / count;
    }
}
