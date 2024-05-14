package org.sorel.leetcode.problem.algorithm.greedy.p0055;

public class Solution {
    public boolean canJump(int[] nums) {
        int max = nums[0];
        for (int i = 1; i <= max && i < nums.length; i++) {
            max = Math.max(max, i + nums[i]);
        }
        return max >= nums.length - 1;
    }
}
