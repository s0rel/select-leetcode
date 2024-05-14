package org.sorel.leetcode.problem.algorithm.dynamicprogramming.p0279;

public class Solution {
    public int numSquares(int n) {
        // 默认初始化值都为 0
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 最坏的情况就是 n 都是由 1 累加来的
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                // 动态转移方程
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
