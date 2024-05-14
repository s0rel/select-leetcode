package org.sorel.leetcode.problem.algorithm.binarytree.p0117;

public class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node head = root;
        while (head != null) {
            Node dummy = new Node();
            Node node = dummy;

            for (Node current = head; current != null; current = current.next) {
                if (current.left != null) {
                    node.next = current.left;
                    node = node.next;
                }
                if (current.right != null) {
                    node.next = current.right;
                    node = node.next;
                }
            }
            head = dummy.next;
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}