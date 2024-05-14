package org.sorel.leetcode.problem.algorithm.twopointers.p0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }

            // 重复值不处理，保证最终的结果不会有重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;
            int target = -nums[i];
            while (j < k) {
                // 重复值不处理，保证最终的结果不会有重复
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }

                if (nums[j] + nums[k] > target) {
                    k--;
                } else if (nums[j] + nums[k] < target) {
                    j++;
                } else {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                }
            }
        }
        return result;
    }
}
