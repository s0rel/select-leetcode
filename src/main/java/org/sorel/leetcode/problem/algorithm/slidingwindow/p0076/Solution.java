package org.sorel.leetcode.problem.algorithm.slidingwindow.p0076;

public class Solution {
    public String minWindow(String s, String t) {
        int[] hash = new int[128];
        t.chars()
                .mapToObj(c -> (char) c)
                .forEach(c -> hash[c]--);

        String result = "";
        for (int i = 0, j = 0, count = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
            if (hash[s.charAt(i)] <= 0) {
                count++;
            }

            // 收缩窗口左边缘
            while (count == t.length() && hash[s.charAt(j)] > 0) {
                hash[s.charAt(j)]--;
                j++;
            }

            if (count == t.length() && (result.isEmpty() || result.length() > i - j + 1)) {
                result = s.substring(j, i + 1);
            }
        }
        return result;
    }
}
