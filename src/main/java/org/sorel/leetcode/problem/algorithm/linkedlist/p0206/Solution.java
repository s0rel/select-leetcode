package org.sorel.leetcode.problem.algorithm.linkedlist.p0206;

import org.sorel.leetcode.datastructure.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        return previous;
    }
}
