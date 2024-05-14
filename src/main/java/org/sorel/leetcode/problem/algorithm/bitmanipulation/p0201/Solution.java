package org.sorel.leetcode.problem.algorithm.bitmanipulation.p0201;

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            n = n & (n - 1);
        }
        return n;
    }
}
