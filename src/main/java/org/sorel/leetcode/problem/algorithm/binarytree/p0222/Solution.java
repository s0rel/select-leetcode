package org.sorel.leetcode.problem.algorithm.binarytree.p0222;

import org.sorel.leetcode.datastructure.TreeNode;

public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        TreeNode left = root;
        TreeNode right = root;
        int height = 0;
        while (right != null) {
            left = left.left;
            right = right.right;
            height++;
        }
        if (left == null) {
            return (1 << height) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
