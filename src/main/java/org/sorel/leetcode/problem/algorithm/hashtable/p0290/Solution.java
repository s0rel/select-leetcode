package org.sorel.leetcode.problem.algorithm.hashtable.p0290;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static boolean wordPattern(String pattern, String s) {
        String[] array = s.split(" ");
        if (pattern.length() != array.length) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (!map.containsKey(c)) {
                if (map.containsValue(array[i])) {
                    return false;
                }
                map.put(c, array[i]);
            } else {
                if (!map.get(c).equals(array[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
