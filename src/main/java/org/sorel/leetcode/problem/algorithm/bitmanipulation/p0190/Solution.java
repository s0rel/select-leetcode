package org.sorel.leetcode.problem.algorithm.bitmanipulation.p0190;

public class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int end = n & 1;
            n >>= 1;
            result <<= 1;
            result |= end;
        }
        return result;
    }
}
