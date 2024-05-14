package org.sorel.leetcode.problem.algorithm.backtracking.p0046;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, new ArrayList<>(), result);
        return result;
    }

    private void backtracking(int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
        } else {
            Arrays.stream(nums).forEach(num -> {
                if (current.contains(num)) {
                    return;
                }

                current.add(num);
                backtracking(nums, current, result);
                current.remove(current.size() - 1);
            });
        }
    }
}
