package org.sorel.leetcode.problem.algorithm.greedy.p0121;

public class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int result = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > result) {
                result = price - minPrice;
            }
        }
        return result;
    }
}
