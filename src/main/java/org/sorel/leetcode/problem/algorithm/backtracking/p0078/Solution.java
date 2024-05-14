package org.sorel.leetcode.problem.algorithm.backtracking.p0078;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtracking(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtracking(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
