package org.sorel.leetcode.problem.algorithm.graph.p0994;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int flashCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    flashCount++;
                }
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int step = 0;
        while (flashCount > 0 && !queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int[] direction : directions) {
                    int x = poll[0] + direction[0];
                    int y = poll[1] + direction[1];
                    if (x >= 0 && x < row && y >= 0 && y < column && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.offer(new int[]{x, y});
                        flashCount--;
                    }
                }
            }
        }
        return flashCount > 0 ? -1 : step;
    }
}
