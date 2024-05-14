package org.sorel.leetcode.problem.algorithm.array.p0918;

public class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max = 0;
        int maxResult = Integer.MIN_VALUE;
        int min = 0;
        int minResult = Integer.MAX_VALUE;
        int sum = 0;
        for (int num : nums) {
            max = Math.max(max + num, num);
            maxResult = Math.max(maxResult, max);
            min = Math.min(min + num, num);
            minResult = Math.min(minResult, min);
            sum += num;
        }

        if (maxResult < 0) {
            return maxResult;
        } else {
            return Math.max(maxResult, sum - minResult);
        }
    }
}
