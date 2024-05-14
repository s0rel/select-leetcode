package org.sorel.leetcode.problem.algorithm.hashtable.p0012;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            while (num >= entry.getKey()) {
                num -= entry.getKey();
                result.append(entry.getValue());
            }
        }
        return result.toString();
    }
}
