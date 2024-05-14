package org.sorel.leetcode.problem.algorithm.heap.p0215;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while (left < right) {
            index = partition(nums, left, right);
            if (index == k) {
                break;
            } else if (index < k) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] nums, int left, int right) {
        int i = left;
        int j = right + 1;
        while (true) {
            while (nums[++i] < nums[left] && i < right) ;
            while (nums[--j] > nums[left] && j > left) ;
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
