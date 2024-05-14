package org.sorel.leetcode.problem.algorithm.array.p0080;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 0;
        while (left < nums.length && right < nums.length) {
            int temp = right;
            while (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                right++;
            }
            if (right - temp >= 1) {
                nums[left++] = nums[right];
            }
            nums[left++] = nums[right++];
        }
        return left;
    }
}
