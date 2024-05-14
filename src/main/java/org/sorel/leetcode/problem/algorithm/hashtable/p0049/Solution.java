package org.sorel.leetcode.problem.algorithm.hashtable.p0049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        Arrays.stream(strs).forEach(str -> {
            // 统计每个字符串都使用了哪些字符
            int[] alphabet = new int[26];
            str.chars()
                    .mapToObj(c -> (char) c)
                    .forEach(c -> alphabet[c - 'a'] += 1);

            // 把使用了相同字符的字符串聚合在一起
            List<String> list = map.containsKey(Arrays.toString(alphabet)) ? map.get(Arrays.toString(alphabet)) : new ArrayList<>();
            list.add(str);
            map.put(Arrays.toString(alphabet), list);
        });
        return new ArrayList<>(map.values());
    }
}
