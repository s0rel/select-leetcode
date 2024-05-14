package org.sorel.leetcode.problem.algorithm.linkedlist.p0086;

import org.sorel.leetcode.datastructure.ListNode;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode lessDummyHead = new ListNode();
        ListNode greaterDummyHead = new ListNode();
        ListNode less = lessDummyHead;
        ListNode greater = greaterDummyHead;
        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }
        greater.next = null;
        less.next = greaterDummyHead.next;
        return lessDummyHead.next;
    }
}