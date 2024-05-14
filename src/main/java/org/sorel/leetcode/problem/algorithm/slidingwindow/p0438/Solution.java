package org.sorel.leetcode.problem.algorithm.slidingwindow.p0438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        int[] alphabetS = new int[26];
        int[] alphabetP = new int[26];

        p.chars()
                .mapToObj(i -> (char) i)
                .forEach(c -> alphabetP[c - 'a']++);
        s.chars()
                .limit(p.length())
                .mapToObj(i -> (char) i)
                .forEach(c -> alphabetS[c - 'a']++);
        if (Arrays.equals(alphabetS, alphabetP)) {
            result.add(0);
        }

        for (int i = 0; i < s.length() - p.length(); i++) {
            alphabetS[s.charAt(i) - 'a']--;
            alphabetS[s.charAt(i + p.length()) - 'a']++;

            if (Arrays.equals(alphabetS, alphabetP)) {
                result.add(i + 1);
            }
        }

        return result;
    }
}
