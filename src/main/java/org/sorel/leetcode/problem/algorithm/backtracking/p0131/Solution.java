package org.sorel.leetcode.problem.algorithm.backtracking.p0131;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void dfs(String s, int index, List<String> path, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++)
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                dfs(s, i + 1, path, result);
                path.remove(path.size() - 1);
            }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

