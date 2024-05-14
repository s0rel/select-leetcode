package org.sorel.leetcode.problem.algorithm.graph.p0211;

public class WordDictionary {
    boolean isEnd;
    private WordDictionary[] items;

    public WordDictionary() {
        items = new WordDictionary[26];
    }

    public void addWord(String word) {
        WordDictionary current = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.items[index] == null) {
                current.items[index] = new WordDictionary();
            }
            current = current.items[index];
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        return search(this, word, 0);
    }

    private boolean search(WordDictionary current, String word, int start) {
        if (start == word.length()) {
            return current.isEnd;
        }
        char c = word.charAt(start);
        if (c != '.') {
            WordDictionary item = current.items[c - 'a'];
            return item != null && search(item, word, start + 1);
        }

        for (int j = 0; j < 26; j++) {
            if (current.items[j] != null && search(current.items[j], word, start + 1)) {
                return true;
            }
        }
        return false;
    }
}
