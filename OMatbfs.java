import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class OMatbfs {
    public int[][] updateMatrix(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                res[i][j] = mat[i][j] != 0 ? updoot(mat, new int[] {i, j, 0}) : 0;
            }
        }

        return res;
    }

    // init[0] is the row index, init[1] is the column index
    // and init[2] is the distance from our initial node
    public int updoot(int[][] mat, int[] init) {
        Queue<int[]> q = new LinkedList<int[]>();
        Set<List<Integer>> visited = new HashSet<>();

        q.add(init);
        visited.add(List.of(init[0], init[1]));

        while (!q.isEmpty()) {
            int[] current_node = q.remove();

            if (mat[current_node[0]][current_node[1]] == 0)
                return current_node[2];

            int[] incs = { -1, 1, 0, 0 };

            int i = 0;
            int j = incs.length-1;

            while (i < incs.length && j >= 0) {
                int[] neigh = { current_node[0] + incs[i++], current_node[1] + incs[j--], current_node[2] + 1};

                if (isValid(mat, neigh) && !visited.contains(List.of(neigh[0], neigh[1]))) {
                    q.add(neigh);
                    visited.add(List.of(neigh[0], neigh[1]));
                }
            }
        }
        return 0;
    }

    public boolean isValid(int[][] mat, int[] idx) {
        return idx[0] >= 0 && idx[0] < mat.length && idx[1] >= 0 && idx[1] < mat[idx[0]].length;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,1,1},
                       {1,1,1},
                       {1,1,1},
                       {1,1,1},
                       {1,1,1},
                       {1,1,1},
                       {1,1,1},
                       {1,1,1},
                       {1,1,1},
                       {1,1,1},
                       {1,1,1},
                       {1,1,1},
                       {1,1,1},
                       {1,1,1},
                       {1,1,1},
                       {1,1,1},
                       {1,1,1},
                       {1,1,1},
                       {1,1,1},
                       {0,0,0}};
        OMatbfs o = new OMatbfs();
        System.out.println(Arrays.deepToString(o.updateMatrix(mat)));
    }
}
