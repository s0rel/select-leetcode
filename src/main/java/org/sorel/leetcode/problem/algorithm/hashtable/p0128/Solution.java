package org.sorel.leetcode.problem.algorithm.hashtable.p0128;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Set<Integer> set = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());
        for (int num : nums) {
            // num - 1 不在集合内， 即 num 是连续序列的起始值，则找到以其为起点的最长连续序列
            if (!set.contains(num - 1)) {
                int consecutive = 1;

                while (set.contains(num + 1)) {
                    num += 1;
                    consecutive += 1;
                }
                result = Math.max(result, consecutive);
            }
        }
        return result;
    }
}
