package org.sorel.leetcode.problem.algorithm.array.p0027;

public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != val) {
                nums[left++] = nums[right];
            }
            right++;
        }
        return left;
    }
}
