package org.sorel.leetcode.problem.algorithm.binarysearch.p0035;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = nums.length;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (target <= nums[middle]) {
                result = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return result;
    }
}
