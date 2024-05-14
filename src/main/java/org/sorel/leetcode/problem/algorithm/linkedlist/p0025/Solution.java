package org.sorel.leetcode.problem.algorithm.linkedlist.p0025;

import org.sorel.leetcode.datastructure.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode previous = dummy;
        while (length >= k) {
            current = previous.next;
            for (int i = 0; i < k - 1; i++) {
                reverse(previous, current);
            }
            previous = current;
            length -= k;
        }
        return dummy.next;
    }

    private void reverse(ListNode previous, ListNode current) {
        ListNode next = current.next;
        current.next = next.next;
        next.next = previous.next;
        previous.next = next;
    }
}
