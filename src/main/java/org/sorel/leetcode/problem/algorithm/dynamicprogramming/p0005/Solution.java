package org.sorel.leetcode.problem.algorithm.dynamicprogramming.p0005;

public class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        int max = 0;
        // dp[i][j] 表示 [s.charAt(i), s.charAt(j)] 为回文串
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                boolean flag = s.charAt(i) == s.charAt(j);
                dp[i][j] = j - i > 2 ? flag && dp[i + 1][j - 1] : flag;
                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    result = s.substring(i, j + 1);
                }
            }
        }
        return result;
    }
}
