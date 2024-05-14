package org.sorel.leetcode.problem.algorithm.array.p0041;

public class Solution {
    // 对于一个长度为 N 的数组，其中没有出现的最小正整数只能在 [1,N+1] 中。
    public int firstMissingPositive(int[] nums) {
        // 消除负数对结果的影响
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = Integer.MAX_VALUE;
            }
        }

        // 对数组内小于 nums.length 的数打标
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num <= nums.length) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
