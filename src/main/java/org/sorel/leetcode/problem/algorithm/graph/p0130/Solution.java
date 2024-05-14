package org.sorel.leetcode.problem.algorithm.graph.p0130;

import java.util.Arrays;

public class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int column = board[0].length;
        for (int i = 0; i < row; i++) {
            dfs(board, i, 0, row, column);
            dfs(board, i, column - 1, row, column);
        }
        for (int i = 0; i < column; i++) {
            dfs(board, 0, i, row, column);
            dfs(board, row - 1, i, row, column);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, int row, int column) {
        if (i < 0 || i >= row || j < 0 || j >= column || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'T';
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Arrays.stream(directions).forEach(direction ->
                dfs(board, i + direction[0], j + direction[1], row, column));
    }
}
