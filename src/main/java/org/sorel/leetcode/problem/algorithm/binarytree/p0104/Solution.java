package org.sorel.leetcode.problem.algorithm.binarytree.p0104;

import org.sorel.leetcode.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result++;
        }
        return result;
    }
}
