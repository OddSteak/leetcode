// [https://leetcode.com/problems/word-ladder/description/]
package graph;

import java.util.List;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ArrayList;

class Node {
    public int pos;
    public int len;

    Node(int pos, int len) {
        this.pos = pos;
        this.len = len;
    }
}

class Graph {
    private List<List<Integer>> adj;
    String beginWord;
    List<String> wordList;

    Graph(String beginWord, List<String> wordList) {
        this.beginWord = beginWord;
        this.wordList = wordList;
        this.adj = new ArrayList<>(1 + wordList.size());

        for (int i = 0; i < 1 + wordList.size(); i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = -1; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (i == -1) {
                    if (isConnected(beginWord, wordList.get(j)))
                        addEdge(i + 1, j + 1);
                } else if (isConnected(wordList.get(i), wordList.get(j))) {
                    addEdge(i + 1, j + 1);
                }
            }
        }
    }

    void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    List<Integer> getIncidentEdges(int u) {
        return adj.get(u);
    }

    String getValue(int u) {
        return u == 0 ? beginWord : wordList.get(u - 1);
    }

    private boolean isConnected(String u, String v) {
        int diff = 0;

        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) != v.charAt(i)) {
                if (++diff > 1)
                    return false;
            }
        }

        return diff == 1;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Graph g = new Graph(beginWord, wordList);
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[1 + wordList.size()];
        q.add(new Node(0, 0));

        while (!q.isEmpty()) {
            Node cur = q.remove();
            visited[cur.pos] = true;

            if (g.getValue(cur.pos).equals(endWord))
                return cur.len + 1;

            for (int e : g.getIncidentEdges(cur.pos)) {
                if (!visited[e])
                    q.add(new Node(e, cur.len + 1));
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
