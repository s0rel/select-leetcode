package org.sorel.leetcode.problem.algorithm.array.p0053;

public class Solution {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max + num);
            result = Math.max(result, max);
        }
        return result;
    }
}
