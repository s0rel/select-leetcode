package org.sorel.leetcode.problem.algorithm.linkedlist.p0141;

import org.sorel.leetcode.datastructure.ListNode;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        // 快慢指针的起始点不能相同
        ListNode fast = head.next;
        ListNode slow = head;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
