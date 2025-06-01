// [https://leetcode.com/problems/word-ladder/description/]
package graph;

import java.util.List;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

class Node {
    public String val;
    public int lvl;

    Node(String val, int lvl) {
        this.val = val;
        this.lvl = lvl;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.add(beginWord);

        if (!wordSet.contains(endWord))
            return 0;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(beginWord, 0));

        while (!q.isEmpty()) {
            Node cur = q.remove();
            wordSet.remove(cur.val);

            if (cur.val.equals(endWord))
                return cur.lvl + 1;

            for (int i = 0; i < cur.val.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char[] curArr = cur.val.toCharArray();
                    curArr[i] = c;
                    String next = new String(curArr);

                    if (wordSet.contains(next))
                        q.add(new Node(next, cur.lvl + 1));
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        int res = sol.ladderLength(beginWord, endWord, wordList);

        assert res == 5;

        String beginWord1 = "hit";
        String endWord1 = "cog";
        List<String> wordList1 = Arrays.asList("hot", "dot", "dog", "lot", "log");
        int res1 = sol.ladderLength(beginWord1, endWord1, wordList1);

        assert res1 == 0;

        String beginWord2 = "hot";
        String endWord2 = "dog";
        List<String> wordList2 = Arrays.asList("hot","dog","dot");
        int res2 = sol.ladderLength(beginWord2, endWord2, wordList2);

        assert res2 == 3;
    }
}
