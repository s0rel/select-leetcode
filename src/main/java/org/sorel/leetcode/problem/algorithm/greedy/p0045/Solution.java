package org.sorel.leetcode.problem.algorithm.greedy.p0045;

public class Solution {
    public int jump(int[] nums) {
        int steps = 0;
        int end = 0;
        int maxPosition = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
