package org.sorel.leetcode.problem.algorithm.binarysearch.p0167;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        int sum = 0;
        while (l < r) {
            sum = numbers[l] + numbers[r];
            if (sum < target) {
                l++;
            } else if (sum > target) {
                r--;
            } else {
                return new int[]{l + 1, r + 1};
            }
        }
        return new int[]{-1, -1};
    }
}
