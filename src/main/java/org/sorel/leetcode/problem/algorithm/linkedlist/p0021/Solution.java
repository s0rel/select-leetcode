package org.sorel.leetcode.problem.algorithm.linkedlist.p0021;

import org.sorel.leetcode.datastructure.ListNode;

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode current = head;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                current.next = list2;
                list2 = list2.next;
            } else {
                current.next = list1;
                list1 = list1.next;
            }
            current = current.next;
        }

        if (list1 != null || list2 != null) {
            current.next = list1 != null ? list1 : list2;
        }
        return head.next;
    }
}
