package org.sorel.leetcode.problem.algorithm.backtracking.p0079;

public class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int column = board[0].length;
        boolean[][] flag = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == word.charAt(0) && search(board, 0, i, j, flag, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, int position, int row, int column, boolean[][] visited, String word) {
        if (position == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length
                || word.charAt(position) != board[row][column]
                || visited[row][column]) {
            return false;
        }

        visited[row][column] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] direction : directions) {
            if (search(board, position + 1, row + direction[0], column + direction[1], visited, word)) {
                return true;
            }
        }
        visited[row][column] = false;
        return false;
    }
}
