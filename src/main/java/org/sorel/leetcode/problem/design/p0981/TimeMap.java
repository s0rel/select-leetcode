package org.sorel.leetcode.problem.design.p0981;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {
    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> treeMap = map.getOrDefault(key, new TreeMap<>());
        treeMap.put(timestamp, value);
        map.put(key, treeMap);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.getOrDefault(key, new TreeMap<>());
        Map.Entry<Integer, String> integerStringEntry = treeMap.floorEntry(timestamp);
        if (integerStringEntry == null) {
            return "";
        }
        return integerStringEntry.getValue();
    }
}
