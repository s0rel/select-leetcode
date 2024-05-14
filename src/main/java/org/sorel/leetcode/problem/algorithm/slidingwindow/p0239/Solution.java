package org.sorel.leetcode.problem.algorithm.slidingwindow.p0239;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Queue<Map.Entry</*数组下标对应的值*/Integer, /*数组的下标*/Integer>> priorityQueue = new PriorityQueue<>((entry1, entry2) ->
                !Objects.equals(entry1.getKey(), entry2.getKey()) ? entry2.getKey() - entry1.getKey() : entry2.getValue() - entry1.getValue());
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(Map.entry(nums[i], i));
        }
        result.add(priorityQueue.peek().getKey());
        for (int i = k; i < nums.length; i++) {
            priorityQueue.offer(Map.entry(nums[i], i));
            // 判断当前最大值是否在滑动窗口内
            while (priorityQueue.peek().getValue() <= i - k) {
                priorityQueue.poll();
            }
            result.add(priorityQueue.peek().getKey());
        }
        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
