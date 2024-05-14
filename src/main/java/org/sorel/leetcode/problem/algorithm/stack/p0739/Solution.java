package org.sorel.leetcode.problem.algorithm.stack.p0739;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        // 维护一个存储下标的单调栈，从栈底到栈顶的下标对应的温度列表中的温度依次递减
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return result;
    }
}
