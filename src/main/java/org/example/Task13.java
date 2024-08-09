package org.example;

/**
 * Развернуть квадратную матрицу в одномерный массив по "улитке" против часовой стрелки,
 * начиная с левого верхнего угла матрицы
 */


public class Task13 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int[][] matrix1 = {
                {1, 2, 3, 4},
        };
        int[][] matrix2 = {
                {1},
                {5},
                {9},
                {13}
        };
        int[][] matrix3 = {
                {1},
        };
        int[][] matrix4 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        int[][] matrix5 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
        };
        int[] result = unrollMatrixSpirally(matrix5);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static int[] unrollMatrixSpirally(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] result = new int[row * col];
        int index = 0;
        int left = 0;
        int right = col - 1;
        int top = 0;
        int bottom = row - 1;
        while (left <= right && top <= bottom) {
            // сверху вниз
            for (int i = top; i <= bottom; i++) {
                result[index++] = matrix[i][left];
            }
            // слева направо
            for (int i = left + 1; i <= right; i++) {
                result[index++] = matrix[bottom][i];
            }
            // на случай матрицы с одним столбцом
            if (left < right) {
                // снизу вверх
                for (int i = bottom - 1; i >= top; i--) {
                    result[index++] = matrix[i][right];
                }
            }
            // на случай матрицы с одной строкой
            if (top < bottom) {
                // справа налево
                for (int i = right - 1; i > left; i--) {
                    result[index++] = matrix[top][i];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }
}
