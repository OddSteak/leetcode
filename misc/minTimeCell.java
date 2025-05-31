import java.util.*;

class Solution {
    public int minimumTime(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        boolean[][] seen = new boolean[m][n];
        seen[0][0] = false;

        if (grid[0][1] > 1 && grid[1][0] > 1)
            return -1;

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.offer(new int[] { 0, 0, 0 });

        int[] dr = { 1, -1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur[1] + dr[i], nc = cur[2] + dc[i];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n || seen[nr][nc])
                    continue;

                seen[nr][nc] = true;
                int nextTime = cur[0] + 1;

                if (nextTime < grid[nr][nc]) {
                    nextTime = grid[nr][nc] + (grid[nr][nc] - nextTime) % 2;
                }

                if (nr == m - 1 && nc == n - 1)
                    return nextTime;

                q.offer(new int[] { nextTime, nr, nc });
            }
        }

        return -1;
    }
}
