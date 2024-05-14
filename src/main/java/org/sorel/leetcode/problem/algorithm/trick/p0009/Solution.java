package org.sorel.leetcode.problem.algorithm.trick.p0009;

public class Solution {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        StringBuilder builder = new StringBuilder();
        builder.append(str);
        return str.contentEquals(builder.reverse());
    }
}
