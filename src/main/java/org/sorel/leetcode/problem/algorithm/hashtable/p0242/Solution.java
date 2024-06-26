package org.sorel.leetcode.problem.algorithm.hashtable.p0242;

import java.util.Arrays;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
            alphabet[t.charAt(i) - 'a']--;
        }
        return Arrays.stream(alphabet)
                .allMatch(i -> i == 0);
    }
}
