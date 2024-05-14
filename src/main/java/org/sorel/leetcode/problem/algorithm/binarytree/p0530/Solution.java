package org.sorel.leetcode.problem.algorithm.binarytree.p0530;

import org.sorel.leetcode.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int getMinimumDifference(TreeNode root) {
        int result = Integer.MAX_VALUE;
        TreeNode previous = null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (previous != null) {
                result = Math.min(result, Math.abs(root.val - previous.val));
            }
            previous = root;
            root = root.right;
        }
        return result;
    }
}
