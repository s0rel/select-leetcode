package org.sorel.leetcode.problem.algorithm.twopointers.p0056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        // 按照区间左节点排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];
            if (result.isEmpty() || result.get(result.size() - 1)[1] < left) {
                result.add(new int[]{left, right});
            } else {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], right);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
