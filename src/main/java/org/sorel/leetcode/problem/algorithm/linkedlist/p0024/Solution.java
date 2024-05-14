package org.sorel.leetcode.problem.algorithm.linkedlist.p0024;

import org.sorel.leetcode.datastructure.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode previous = dummy;
        while (previous.next != null && previous.next.next != null) {
            ListNode node1 = previous.next;
            ListNode node2 = previous.next.next;
            node1.next = node2.next;
            node2.next = node1;
            previous.next = node2;
            previous = node1;
        }
        return dummy.next;
    }
}
