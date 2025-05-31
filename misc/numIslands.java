class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int row, int col, boolean[][] visited) {
        if (!visited[row][col]) {
            visited[row][col] = true;

            int[] dir = {1, -1, 0, 0};

            for (int i = 0; i < dir.length; i++) {
                int newRow = row + dir[i];
                int newCol = col + dir[3 - i];

                if (isValid(newRow, newCol, grid)) {
                    if (grid[newRow][newCol] == '1')
                        dfs(grid, newRow, newCol, visited);
                }
            }
        }
    }

    public boolean isValid(int row, int col, char[][] grid) {
        return row >= 0 && col >= 0 && row < grid.length && col < grid[row].length;
    }

    public static void main(String[] args) {
        char[][] grid = {
              {'1','1','0','0','0'},
              {'1','1','0','0','0'},
              {'0','0','1','0','0'},
              {'0','0','0','1','1'}
            };

        Solution sol = new Solution();

        System.out.println(sol.numIslands(grid));
    }
}
