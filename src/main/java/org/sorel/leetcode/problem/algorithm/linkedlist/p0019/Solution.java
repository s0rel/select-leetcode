package org.sorel.leetcode.problem.algorithm.linkedlist.p0019;

import org.sorel.leetcode.datastructure.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = head;
        ListNode right = head;
        while (right != null && n > 0) {
            right = right.next;
            n--;
        }

        if (right == null) {
            return head.next;
        }

        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return head;
    }
}
