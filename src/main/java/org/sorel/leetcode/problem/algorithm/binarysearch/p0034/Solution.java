package org.sorel.leetcode.problem.algorithm.binarysearch.p0034;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (target > nums[middle]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        if (target != nums[left]) {
            return new int[]{-1, -1};
        }

        int[] result = new int[2];
        result[0] = left;

        right = nums.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2 + 1;
            if (target < nums[middle]) {
                right = middle - 1;
            } else {
                left = middle;
            }
        }
        result[1] = (target == nums[right]) ? right : -1;

        return result;
    }
}
