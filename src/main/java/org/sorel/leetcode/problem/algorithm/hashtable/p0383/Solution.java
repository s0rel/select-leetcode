package org.sorel.leetcode.problem.algorithm.hashtable.p0383;

import java.util.Arrays;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alphabet = new int[26];
        magazine.chars()
                .mapToObj(c -> (char) c)
                .forEach(c -> alphabet[c - 'a']++);
        ransomNote.chars()
                .mapToObj(c -> (char) c)
                .forEach(c -> alphabet[c - 'a']--);
        return Arrays.stream(alphabet)
                .allMatch(i -> i >= 0);
    }
}
