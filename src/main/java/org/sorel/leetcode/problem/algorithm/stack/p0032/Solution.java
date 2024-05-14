package org.sorel.leetcode.problem.algorithm.stack.p0032;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int longestValidParentheses(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        // 保证当有左括号出栈时，有栈顶元素可以配合计算长度，选择 -1 是因为下标是从 0 开始的
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    result = Math.max(result, i - stack.peek());
                }
            }
        }
        return result;
    }
}
