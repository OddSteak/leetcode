import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int[] walls = { matrix[0].length, matrix.length, -1, -1 };
        int curDir = 0;
        int i = 0, j = 0;

        while (res.size() != matrix.length * matrix[0].length) {
            if ((curDir == 0 || curDir == 2) ) {
                if (walls[curDir] == j - (curDir - 1)) {
                    if (curDir == 0) walls[3]++;
                    if (curDir == 2) walls[1]--;
                    curDir++;
                    continue;
                }

                res.add(matrix[i][j]);
                j -= curDir - 1;
            }

            else if (curDir == 1 || curDir == 3) {
                int add;
                if (curDir == 1) add = 1;
                else add = -1;

                if (walls[curDir] == i + add) {
                    if (curDir == 1) {
                        walls[0]--;
                        curDir++;
                    }
                    else {
                        walls[2]++;
                        curDir = 0;
                    }
                    continue;
                }

                res.add(matrix[i][j]);
                i += add;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.spiralOrder(new int[][] {{1,2,3},{4,5,6},{7,8,9}}).toString());
        System.out.println(sol.spiralOrder(new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}}).toString());
    }
}
