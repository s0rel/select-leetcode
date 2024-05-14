package org.sorel.leetcode.problem.algorithm.stack.p0394;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                count = count * 10 + c - '0';
            } else if (c == '[') {
                countStack.push(count);
                stringStack.push(result);
                result = new StringBuilder();
                count = 0;
            } else if (c == ']') {
                StringBuilder temp = result;
                result = stringStack.pop();
                for (count = countStack.pop(); count > 0; count--) {
                    result.append(temp);
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
