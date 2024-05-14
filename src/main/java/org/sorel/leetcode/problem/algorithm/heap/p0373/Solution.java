package org.sorel.leetcode.problem.algorithm.heap.p0373;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> queue = new PriorityQueue<>((a, b) -> a.get(0) + a.get(1) - b.get(0) - b.get(1));
        for (int i = 0; i < nums1.length && i < k; i++) {
            queue.offer(List.of(nums1[i], nums2[0], 0));
        }
        while (k-- > 0 && !queue.isEmpty()) {
            List<Integer> list = queue.poll();
            result.add(Arrays.asList(list.get(0), list.get(1)));
            if (list.get(2) == nums2.length - 1) {
                continue;
            }
            queue.offer(List.of(list.get(0), nums2[list.get(2) + 1], list.get(2) + 1));
        }
        return result;
    }
}
