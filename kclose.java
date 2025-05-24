import java.util.Comparator;
import java.util.PriorityQueue;

class Node {
    int x;
    int y;
    double priority;

    Node(int x, int y, double priority) {
        this.x = x;
        this.y = y;
        this.priority = priority;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingDouble(n -> n.priority));

        for (int i = 0; i < points.length; i++)
            pq.add(new Node(points[i][0], points[i][1], Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2))));

        for (int i = 0; i < k; i++) {
            Node n = pq.poll();

            if (n == null)
                break;

            res[i] = new int[]{n.x, n.y};
        }

        return res;
    }
}
