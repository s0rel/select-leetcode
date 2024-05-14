package org.sorel.leetcode.problem.algorithm.linkedlist.p0023;

import org.sorel.leetcode.datastructure.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // 按照链表表头排序
        Queue<ListNode> queue = new PriorityQueue<>((Comparator.comparingInt(o -> o.val)));
        Arrays.stream(lists)
                .filter(Objects::nonNull)
                .forEach(queue::offer);

        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            current.next = node;
            current = current.next;
            node = node.next;
            if (node != null) {
                queue.offer(node);
            }
        }
        return dummy.next;
    }
}
