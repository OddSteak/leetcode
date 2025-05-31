// [https://leetcode.com/problems/course-schedule-ii/description/]

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Graph {
    public List<List<Integer>> adj;

    // build a graph adjacency list with numCourses nodes
    Graph(int numCourses) {
        this.adj = new ArrayList<>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            this.adj.add(new ArrayList<>());
        }
    }

    // add edge u -> v
    void addEdge(int u, int v) {
        this.adj.get(u).add(v);
    }

    // get connected vertices to u
    List<Integer> getNeighbours(int u) {
        return this.adj.get(u);
    }
}

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        int[] current_label = new int[]{numCourses - 1};

        int[] status = new int[numCourses];
        Graph g = new Graph(numCourses);

        for (int[] pre : prerequisites)
            g.addEdge(pre[1], pre[0]);

        for (int i = 0; i < numCourses; i++) {
            // process all unexplored nodes
            if (status[i] == 0 && !canFinishDfs(status, g, order, current_label, i))
                    return new int[]{};
        }

        return order;
    }

    public boolean canFinishDfs(int[] status, Graph g, int[] order, int[] current_label, int node) {
        // node is in current path
        if (status[node] == 1)
            return false;

        // node is in a previously explored path
        if (status[node] == 2)
            return true;

        // visit the node
        status[node] = 1;

        for (int neigh: g.getNeighbours(node)) {
            if (!canFinishDfs(status, g, order, current_label, neigh))
                return false;
        }

        // mark node processed
        status[node] = 2;
        order[current_label[0]] = node;
        current_label[0]--;
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int num = 2;
        int[][] pre = {{1, 0}};
        int[] ans = new int[]{0, 1};
        int[] received = sol.findOrder(num, pre);

        assert Arrays.equals(received, ans);

        int num1 = 4;
        int[][] pre1 = {{1,0},{2,0},{3,1},{3,2}};;
        int[] ans1 = new int[]{0, 2, 1, 3};
        int[] received1 = sol.findOrder(num1, pre1);

        assert Arrays.equals(received1, ans1);

        int num2 = 1;
        int[][] pre2 = {};
        int[] ans2 = new int[]{0};

        assert Arrays.equals(sol.findOrder(num2, pre2), ans2);
    }
}
