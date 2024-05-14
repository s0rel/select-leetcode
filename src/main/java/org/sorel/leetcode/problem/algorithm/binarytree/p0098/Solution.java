package org.sorel.leetcode.problem.algorithm.binarytree.p0098;

import org.sorel.leetcode.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode previous = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();

            // 二叉搜索树的中序遍历一次访问当前节点的左节点->当前节点->当前节点的右节点，且结果是升序的，因此可以利用中序遍历判断是否是二叉搜索树
            if (previous != null && root.val <= previous.val) {
                return false;
            }
            previous = root;
            root = root.right;
        }
        return true;
    }
}
