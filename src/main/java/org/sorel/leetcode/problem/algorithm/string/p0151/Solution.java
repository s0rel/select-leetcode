package org.sorel.leetcode.problem.algorithm.string.p0151;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String reverseWords(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (s.charAt(left) == ' ') {
            left++;
        }
        while (s.charAt(right) == ' ') {
            right--;
        }

        Deque<String> stack = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();
        while (left <= right) {
            if (s.charAt(left) == ' ') {
                stack.push(word.toString());
                word.delete(0, word.length());
                while (left <= right && s.charAt(left) == ' ') {
                    left++;
                }
            } else {
                word.append(s.charAt(left));
                left++;
            }
        }
        stack.push(word.toString());
        return String.join(" ", stack);
    }
}
