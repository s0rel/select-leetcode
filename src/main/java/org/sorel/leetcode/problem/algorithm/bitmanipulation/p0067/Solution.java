package org.sorel.leetcode.problem.algorithm.bitmanipulation.p0067;

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int length = Math.max(a.length(), b.length());
        int carry = 0;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum = (i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0) +
                    (i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0) + carry;
            result.append((char) (sum % 2 + '0'));
            carry = sum / 2;
        }

        if (carry > 0) {
            result.append('1');
        }
        result.reverse();
        return result.toString();
    }
}
