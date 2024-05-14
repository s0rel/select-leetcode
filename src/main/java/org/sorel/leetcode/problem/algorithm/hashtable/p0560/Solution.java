package org.sorel.leetcode.problem.algorithm.hashtable.p0560;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        // 记录遍历过程中数组之和及其出现次数
        Map</*遍历到的数组元素之和*/Integer, /*和出现的次数*/Integer> map = new HashMap<>();
        // 递推式的基线条件
        map.put(0, 1);
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
