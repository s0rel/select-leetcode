package org.sorel.leetcode.problem.algorithm.string.p0006;

public class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] result = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            result[i] = new StringBuilder();
        }

        for (int i = 0; i < s.length(); ) {
            // 竖直向下操作
            for (int j = 0; j < numRows && i < s.length(); j++) {
                result[j].append(s.charAt(i));
                i++;
            }

            // 沿对角线向上操作
            for (int j = numRows - 2; j > 0 && i < s.length(); j--) {
                result[j].append(s.charAt(i));
                i++;
            }
        }
        return String.join("", result);
    }
}
