package org.sorel.leetcode.problem.algorithm.bitmanipulation.p0191;

public class Solution {
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            n = n & (n - 1);
            result++;
        }
        return result;
    }
}
