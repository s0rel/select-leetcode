package org.sorel.leetcode.problem.algorithm.twopointers.p0283;

import java.util.Arrays;

public class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        Arrays.fill(nums, index, nums.length, 0);
    }

    class SolutionI {
        public void moveZeroesI(int[] nums) {
            int left = 0;
            int right = 0;
            while (left < nums.length && right < nums.length) {
                if (nums[left] == 0) {
                    while (right < nums.length && nums[right] == 0) {
                        right++;
                    }
                    if (right < nums.length && right > left) {
                        swap(nums, left, right);
                    }
                }
                left++;
                right++;
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
