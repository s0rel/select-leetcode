package org.sorel.leetcode.problem.algorithm.binarytree.p0230;

import org.sorel.leetcode.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        int count = 0;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            count++;
            if (count == k) {
                return root.val;
            }
            root = root.right;
        }
        return Integer.MIN_VALUE;
    }
}
