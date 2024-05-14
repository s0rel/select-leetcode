package org.sorel.leetcode.problem.algorithm.matrix.p0048;

public class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        // 水平翻转
        for (int i = 0; i < row / 2; i++) {
            for (int j = 0; j < column; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[row - i - 1][j];
                matrix[row - i - 1][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < column; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
