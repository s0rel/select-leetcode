package org.sorel.leetcode.problem.algorithm.array.p0274;

import java.util.Arrays;

public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int result = 0;
        int index = citations.length - 1;
        while (index >= 0 && citations[index] > result) {
            result++;
            index--;
        }
        return result;
    }
}
