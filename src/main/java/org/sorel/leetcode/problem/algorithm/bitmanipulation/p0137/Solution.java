package org.sorel.leetcode.problem.algorithm.bitmanipulation.p0137;

public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                if ((num >> i & 1) == 1) {
                    sum++;
                }
            }
            sum %= 3;
            result |= (sum << i);
        }
        return result;
    }
}
