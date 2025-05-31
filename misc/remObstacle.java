import java.util.*;

class Node {
    public int i;
    public int j;

    public Node(int i , int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Node other = (Node) o;
        return other.i == this.i && other.j == this.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}

class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Deque<Node> dq = new LinkedList<>();
        dq.add(new Node(0, 0));

        int[] dist = new int[m * n];
        for (int i = 0; i < dist.length; i++)
            dist[i] = Integer.MAX_VALUE;
        dist[0] = 0;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!dq.isEmpty()) {
            Node cur = dq.removeFirst();

            for (int i = 0; i < 4; i++) {
                int x = cur.i + dx[i];
                int y = cur.j + dy[i];

                if (x >= 0 && x < m && y >= 0 && y < grid[x].length) {
                    if (grid[x][y] == 0 && dist[cur.i * n + cur.j] < dist[x * n + y] ) {
                        dist[x * n + y] = dist[cur.i * n + cur.j];
                        dq.addFirst(new Node(x, y));
                    } else if (grid[x][y] == 1 &&  dist[cur.i * n + cur.j] + 1 < dist[x * n + y]) {
                        dist[x * n + y] = dist[cur.i * n + cur.j] + 1;
                        dq.addLast(new Node(x, y));
                    }
                }
            }
        }

        return dist[(m - 1) * n + (n - 1)];
    }
}
