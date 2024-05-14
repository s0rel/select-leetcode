package org.sorel.leetcode.problem.design.p0146;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private final Map<Integer, Integer> cache;
    private final int max;

    public LRUCache(int capacity) {
        max = capacity;
        cache = new LinkedHashMap<>(capacity, 1.0f, true) {
            @Override
            public boolean removeEldestEntry(Map.Entry eldest) {
                return cache.size() > max;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
