package org.sorel.leetcode.problem.algorithm.trick.p0169;

public class Solution {
    /**
     * Boyer-Moore 投票算法
     */
    public int majorityElement(int[] nums) {
        int majorityElement = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                majorityElement = num;
            }

            count += (num == majorityElement) ? 1 : -1;
        }
        return majorityElement;
    }
}
