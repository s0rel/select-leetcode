package org.sorel.leetcode.problem.algorithm.slidingwindow.p0003;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map</*字符串中的字符*/Character, /*字符串中的字符对应的下标*/Integer> map = new HashMap<>();
        int result = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // 如果字符已经出现过，那么窗口的左边缘可以跳过字符对应的下标之前的内容
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            result = Math.max(result, right - left + 1);
            // 保证字符对应的下标是字符串靠后的位置
            map.put(c, right);
        }
        return result;
    }
}
