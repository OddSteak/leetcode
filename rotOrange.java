import java.util.*;

class Node {
    int row, col, level;

    Node(int row, int col, int lvl) {
        this.row = row;
        this.col = col;
        this.level = lvl;
    }
}

class Solution {
    public static int orangesRotting(int[][] grid) {
        return bfs(grid);
    }

    public static int bfs(int[][] grid) {
        Queue<Node> q = new LinkedList<>();
        int lvl = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2)
                    q.add(new Node(i, j, 0));
            }
        }

        while (!q.isEmpty()) {
            Node cur = q.remove();
            lvl = Math.max(cur.level, lvl);
            int[] dir = { 1, -1, 0, 0 };

            for (int i = 0; i < dir.length; i++) {
                int newRow = cur.row + dir[i];
                int newCol = cur.col + dir[3 - i];

                if (isValidCoord(grid, newRow, newCol)
                        && grid[newRow][newCol] == 1) {
                    grid[newRow][newCol] = 2;
                    q.add(new Node(newRow, newCol, cur.level + 1));
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }

        return lvl;
    }

    public static int brute(int[][] grid) {
        int min = 0;

        while (true) {
            int[][] copy = deepCopy(grid);
            min++;

            if (!minute(copy, grid)) {
                break;
            }

            if (Arrays.equals(grid, copy))
                return -1;
        }

        return min;
    }

    public static boolean minute(int[][] grid, int[][] out) {
        boolean leftFresh = false;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    if (rottenNeigh(grid, i, j)) {
                        out[i][j] = 2;
                    } else {
                        leftFresh = true;
                    }
                }
            }
        }

        return leftFresh;
    }

    public static boolean rottenNeigh(int[][] grid, int row, int col) {
        int[] dir = { 1, -1, 0, 0 };

        for (int i = 0; i < dir.length; i++) {
            int newRow = row + dir[i];
            int newCol = col + dir[3 - i];

            if (isValidCoord(grid, newRow, newCol)
                    && grid[newRow][newCol] == 2) {
                return true;
            }
        }

        return false;
    }

    public static boolean isValidCoord(int[][] grid, int row, int col) {
        return row >= 0 && col >= 0 && row < grid.length && col < grid[row].length;
    }

    public static int[][] deepCopy(int[][] grid) {
        int[][] res = new int[grid.length][];

        for (int i = 0; i < grid.length; i++) {
            res[i] = grid[i].clone();
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] grid = { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
        System.out.println(orangesRotting(grid));
    }
}
