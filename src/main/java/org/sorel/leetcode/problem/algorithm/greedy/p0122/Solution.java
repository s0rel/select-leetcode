package org.sorel.leetcode.problem.algorithm.greedy.p0122;

public class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int previous = prices[0];
        for (int price : prices) {
            if (price > previous) {
                result += (price - previous);
            }
            previous = price;
        }
        return result;
    }
}
