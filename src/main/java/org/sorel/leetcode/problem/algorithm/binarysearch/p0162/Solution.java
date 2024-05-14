package org.sorel.leetcode.problem.algorithm.binarysearch.p0162;

public class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] > nums[middle + 1]) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }
}
