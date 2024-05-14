package org.sorel.leetcode.problem.algorithm.linkedlist.p0002;

import org.sorel.leetcode.datastructure.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode current = head;
        int flag = 0;
        int sum = 0;

        // 遍历两个列表对节点的值进行求和
        while (l1 != null || l2 != null) {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;
            sum = v1 + v2 + flag;
            flag = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            l1 = (l1 != null) ? l1.next : l1;
            l2 = (l2 != null) ? l2.next : l2;
        }

        // 处理最高位发生进位的情况
        if (flag > 0) {
            current.next = new ListNode(1);
        }

        return head.next;
    }
}
