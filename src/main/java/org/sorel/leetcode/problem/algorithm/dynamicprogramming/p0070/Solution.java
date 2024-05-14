package org.sorel.leetcode.problem.algorithm.dynamicprogramming.p0070;

public class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int first = 1;
        int second = 2;
        int count = 0;
        for (int i = 2; i < n; i++) {
            count = first + second;
            first = second;
            second = count;
        }
        return count;
    }
}
