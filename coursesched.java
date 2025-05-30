// [https://leetcode.com/problems/course-schedule]

import java.util.*;

class Graph {
    public List<List<Integer>> adj;

    Graph(int numCourses) {
        this.adj = new ArrayList<>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            this.adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v) {
        this.adj.get(u).add(v);
    }

    List<Integer> getNeighbours(int u) {
        return this.adj.get(u);
    }
}


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph g = new Graph(numCourses);
        // 0 -> unprocessed, 1 -> visiting, 2 -> processed
        int[] status = new int[numCourses];

        for (int[] pre : prerequisites)
            g.addEdge(pre[0], pre[1]);

        for (int i = 0; i < numCourses; i++) {
            if (status[i] == 0) {
                if (!canFinishDfs(status, g, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean canFinishDfs(int[] status, Graph g, int i) {
        if (status[i] == 1)
            return false;

        if (status[i] == 2)
            return true;

        status[i] = 1;

        for (int neigh: g.getNeighbours(i)) {
            if (!canFinishDfs(status, g, neigh))
                return false;
        }

        status[i] = 2;
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] pre = new int[][]{{1, 0}};
        int numC = 2;

        assert sol.canFinish(numC, pre);

        int[][] pre1 = {{0,1},{1,2},{0,3},{3,0}};
        int num1 = 4;

        assert !sol.canFinish(num1, pre1);
    }
}
