package org.sorel.leetcode.problem.algorithm.dynamicprogramming.p0152;

public class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int[] max = new int[nums.length + 1];
        int[] min = new int[nums.length + 1];
        max[0] = min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(nums[i], Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]));
            min[i] = Math.min(nums[i], Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]));
            result = Math.max(result, max[i]);
        }
        return result;
    }
}
