package org.sorel.leetcode.problem.algorithm.stack.p0042;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int trap(int[] height) {
        int result = 0;
        // 维护一个单调栈，单调栈存储的是下标，满足从栈底到栈顶的下标对应的数组 height 中的元素递减。
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }

                int left = stack.peek();
                result += (i - left - 1) * (Math.min(height[left], height[i]) - height[top]);
            }
            stack.push(i);
        }
        return result;
    }
}
