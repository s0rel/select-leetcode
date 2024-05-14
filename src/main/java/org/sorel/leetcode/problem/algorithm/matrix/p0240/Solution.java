package org.sorel.leetcode.problem.algorithm.matrix.p0240;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int i = row - 1;
        int j = 0;
        while (j < column && i >= 0) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target < matrix[i][j]) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}
