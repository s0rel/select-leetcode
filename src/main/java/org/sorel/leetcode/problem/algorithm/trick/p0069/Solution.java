package org.sorel.leetcode.problem.algorithm.trick.p0069;

public class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int result = -1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if ((long) middle * middle <= x) {
                result = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return result;
    }
}
