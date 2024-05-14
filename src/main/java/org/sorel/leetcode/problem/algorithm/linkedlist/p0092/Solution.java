package org.sorel.leetcode.problem.algorithm.linkedlist.p0092;

import org.sorel.leetcode.datastructure.ListNode;

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode previous = dummy;
        for (int i = 0; i < left - 1; i++) {
            previous = previous.next;
        }

        ListNode current = previous.next;
        ListNode next = current.next;
        for (int i = 0; i < right - left; i++) {
            current.next = next.next;
            next.next = previous.next;
            previous.next = next;
            next = current.next;
        }
        return dummy.next;
    }
}
