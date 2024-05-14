package org.sorel.leetcode.problem.algorithm.linkedlist.p0082;

import org.sorel.leetcode.datastructure.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            if (current.next.val == current.next.next.val) {
                int x = current.next.val;
                while (current.next != null && current.next.val == x) {
                    current.next = current.next.next;
                }
            } else {
                current = current.next;
            }
        }
        return dummy.next;
    }
}
