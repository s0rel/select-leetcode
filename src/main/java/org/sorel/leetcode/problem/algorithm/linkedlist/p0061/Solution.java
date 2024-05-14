package org.sorel.leetcode.problem.algorithm.linkedlist.p0061;

import org.sorel.leetcode.datastructure.ListNode;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        int add = length - k % length;
        if (add == length) {
            return head;
        }

        current.next = head;
        while (add-- > 0) {
            current = current.next;
        }

        ListNode result = current.next;
        current.next = null;
        return result;
    }
}
