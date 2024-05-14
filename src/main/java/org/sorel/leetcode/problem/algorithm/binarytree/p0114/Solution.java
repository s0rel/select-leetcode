package org.sorel.leetcode.problem.algorithm.binarytree.p0114;

import org.sorel.leetcode.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode previous = null;
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (previous != null) {
                previous.left = null;
                previous.right = current;
            }

            TreeNode left = current.left;
            TreeNode right = current.right;
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
            previous = current;
        }
    }
}
