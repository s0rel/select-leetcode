package org.sorel.leetcode.problem.algorithm.hashtable.p0001;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 题干中不允许使用相同的元素，所以可以使用数组下标对应的值为哈希表的键
        Map</*数组下标对应的值*/Integer, /*数组下标*/Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }
}
