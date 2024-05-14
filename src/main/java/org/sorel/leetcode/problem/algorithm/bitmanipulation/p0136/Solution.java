package org.sorel.leetcode.problem.algorithm.bitmanipulation.p0136;

public class Solution {
    public int singleNumber(int[] nums) {
        int singleNumber = 0;
        for (int num : nums) {
            // a ^ a = 0, 且异或满足交换律
            singleNumber ^= num;
        }
        return singleNumber;
    }
}
