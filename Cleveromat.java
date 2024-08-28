import java.util.LinkedList;
import java.util.Queue;

class Cleveromat {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[][] res = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] current_node = q.poll();
            int row = current_node[0];
            int col = current_node[1];

            int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};

            for (int i = 0; i < dirs.length; i++) {
                int newRow = row + dirs[i][0];
                int newCol = col + dirs[i][1];

                if (isValid(mat, newRow, newCol) && !visited[newRow][newCol]) {
                    res[newRow][newCol] = res[row][col] + 1;
                    q.add(new int[] {newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
        return res;
    }

    public boolean isValid(int[][] mat, int row, int col) {
        return row >= 0 && row < mat.length && col >= 0 && col < mat[row].length;
    }
}
