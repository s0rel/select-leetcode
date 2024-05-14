package org.sorel.leetcode.problem.algorithm.graph.p0200;

import java.util.Arrays;

public class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        int row = grid.length;
        int column = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, row, column);
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int i, int j, int row, int column) {
        if (i < 0 || i >= row || j < 0 || j >= column || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Arrays.stream(directions).forEach(direction ->
                dfs(grid, i + direction[0], j + direction[1], row, column)
        );
    }
}
