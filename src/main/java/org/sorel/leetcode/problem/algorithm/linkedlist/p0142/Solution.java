package org.sorel.leetcode.problem.algorithm.linkedlist.p0142;

import org.sorel.leetcode.datastructure.ListNode;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode node = head;
        slow = slow.next;
        while (node != slow) {
            node = node.next;
            slow = slow.next;
        }
        return node;
    }
}
