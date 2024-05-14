package org.sorel.leetcode.problem.algorithm.stack.p0020;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> pairs = Map.ofEntries(
                Map.entry(')', '('),
                Map.entry(']', '['),
                Map.entry('}', '{')
        );
        s.chars()
                .mapToObj(c -> (char) c)
                .forEach(c -> {
                    if (pairs.containsValue(c)) {
                        stack.push(c);
                    } else {
                        if (!stack.isEmpty() && stack.peek().equals(pairs.get(c))) {
                            stack.pop();
                        } else {
                            stack.push(c);
                        }
                    }
                });
        return stack.isEmpty();
    }
}
