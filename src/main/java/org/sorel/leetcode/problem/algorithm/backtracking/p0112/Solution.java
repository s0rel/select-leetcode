package org.sorel.leetcode.problem.algorithm.backtracking.p0112;

import org.sorel.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();
        return backtracking(root, targetSum, path);
    }

    private boolean backtracking(TreeNode root, int targetSum, List<Integer> path) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && targetSum == root.val) {
            return true;
        }

        path.add(root.val);
        boolean hasPath = backtracking(root.left, targetSum - root.val, path) ||
                backtracking(root.right, targetSum - root.val, path);
        path.remove(path.size() - 1);
        return hasPath;
    }
}
