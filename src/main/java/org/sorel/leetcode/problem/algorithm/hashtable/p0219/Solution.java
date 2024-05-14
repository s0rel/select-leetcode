package org.sorel.leetcode.problem.algorithm.hashtable.p0219;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map</*数组的值*/Integer, /*数组的值对应的下标*/List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            if (map.containsKey(nums[i])) {
                list = map.get(nums[i]);
                for (int index : list) {
                    if (Math.abs(i - index) <= k) {
                        return true;
                    }
                }
            }
            list.add(i);
            map.put(nums[i], list);
        }
        return false;
    }
}
