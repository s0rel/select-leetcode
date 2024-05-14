package org.sorel.leetcode.problem.algorithm.array.p0026;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 0;
        while (left < nums.length && right < nums.length) {
            while (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                right++;
            }
            nums[left++] = nums[right++];
        }
        return left;
    }
}
