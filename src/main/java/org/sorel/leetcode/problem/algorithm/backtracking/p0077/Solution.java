package org.sorel.leetcode.problem.algorithm.backtracking.p0077;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        backtracking(nums, 0, k, new ArrayList<>(), res);
        return res;
    }

    private void backtracking(int[] nums, int index, int k, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
        } else if (current.size() < k) {
            for (int i = index; i < nums.length; i++) {
                current.add(nums[i]);
                backtracking(nums, i + 1, k, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}
