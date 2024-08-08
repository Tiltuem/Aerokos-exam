package org.example;

/*
Найти среднее арифметическое всex элементов,
находящихся одновременно справа от побочной и главной диагонали целочисленной квадратной матрицы.
*/
public class FourthTask {
    public static void main(String[] args) {
        // 8, 12
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        // 8, 12, 12, 16
        int[][] matrix2 = {
                {1, 2, 3, 4, 4},
                {5, 6, 7, 8, 8},
                {9, 10, 11, 12, 12},
                {13, 14, 15, 16, 16},
                {17, 18, 19, 20, 20}};

        // 9, 13, 12, 17, 16, 17, 17
        int[][] matrix3 = {
                {1, 2, 3, 4, 4, 5},
                {5, 6, 7, 8, 8, 9},
                {9, 10, 11, 12, 12, 13},
                {13, 14, 15, 16, 16, 17},
                {13, 14, 15, 16, 16, 17},
                {17, 18, 19, 20, 20, 20}};

        System.out.println(averageLeftOfDiagonals(matrix));
    }


    public static double averageLeftOfDiagonals(int[][] matrix) {
        double sum = 0;
        int count = 0;
        int row = 1, column = matrix.length - 1, temp = matrix.length - 2, length = matrix.length;

        while (row < length) {
            while (column > temp) {
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
