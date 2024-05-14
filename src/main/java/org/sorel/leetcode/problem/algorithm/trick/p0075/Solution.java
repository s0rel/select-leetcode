package org.sorel.leetcode.problem.algorithm.trick.p0075;

public class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        // 最后一位元素也需要考虑，必须取"<="
        for (int i = 0; i <= right; i++) {
            // 为了保证 2 在前，0 在后的情况也能正常处理，必须先处理等于 2 的情况，然后再处理等于 0 的情况
            while (nums[i] == 2 && i < right) {
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right--;
            }

            // 等于 0 的情况，只需要处理一次，因为等于 1 的情况不需要处理
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }
}
