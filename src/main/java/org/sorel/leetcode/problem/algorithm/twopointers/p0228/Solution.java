package org.sorel.leetcode.problem.algorithm.twopointers.p0228;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        int left = 0;
        int right = 1;
        while (right <= nums.length) {
            if (right == nums.length || nums[right] - nums[left] != right - left) {
                StringBuilder temp = new StringBuilder(nums[left]);
                if (right - left > 1) {
                    temp.append("->");
                    temp.append(nums[right - 1]);
                }
                result.add(temp.toString());
                left = right;
            }
            right++;
        }
        return result;
    }
}
