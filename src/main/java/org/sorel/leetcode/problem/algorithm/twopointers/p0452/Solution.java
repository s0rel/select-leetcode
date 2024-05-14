package org.sorel.leetcode.problem.algorithm.twopointers.p0452;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        List<int[]> result = new ArrayList<>();
        // 按照区间左节点排序
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        for (int[] point : points) {
            int left = point[0];
            int right = point[1];
            if (result.isEmpty() || result.get(result.size() - 1)[1] < left) {
                result.add(new int[]{left, right});
            } else {
                result.get(result.size() - 1)[1] = Math.min(result.get(result.size() - 1)[1], right);
            }
        }
        return result.size();
    }
}
