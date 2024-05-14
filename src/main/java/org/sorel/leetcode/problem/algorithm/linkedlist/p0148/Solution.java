package org.sorel.leetcode.problem.algorithm.linkedlist.p0148;

import org.sorel.leetcode.datastructure.ListNode;

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            current = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        current.next = null;
        ListNode list1 = sortList(head);
        ListNode list2 = sortList(slow);
        return merge(list1, list2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode current = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next = (l1 != null) ? l1 : l2;
        return head.next;
    }
}
