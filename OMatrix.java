// 01 Matrix
import java.util.ArrayList;
import java.util.Arrays;

class OMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }
                res[i][j] = recFind(mat, i, j, 0, new ArrayList<ArrayList<Integer>>());
            }
        }

        return res;
    }

    public int recFind(int[][] mat, int i, int j, int counter, ArrayList<ArrayList<Integer>> forb) {
        forb.add(new ArrayList<Integer>(Arrays.asList(i, j)));

        if (!isValid(mat, i, j))
            return -1;

        for (int inc = 1; inc > -2; inc -= 2) {
            if (isValid(mat, i, j + inc) && mat[i][j + inc] == 0) {
                return counter + 1;
            }
            if (isValid(mat, i + inc, j) && mat[i + inc][j] == 0) {
                return counter + 1;
            }
        }

        var distArr = new ArrayList<Integer>();
        ArrayList<Integer> futureForb;

        int dist = 0;

        for (int inc = 1; inc > -2; inc -= 2) {
            futureForb = new ArrayList<Integer>();
            futureForb.add(i);
            futureForb.add(j+inc);
            if (!forb.contains(futureForb)) {
                dist = recFind(mat, i, j + inc, counter + 1, forb);
                if (counter == 0) {
                    forb.clear();
                    forb.add(new ArrayList<Integer>(Arrays.asList(i, j)));
                }
                if (dist == counter + 2) return counter+2;
                if (dist != -1) distArr.add(dist);
            }

            futureForb = new ArrayList<Integer>();
            futureForb.add(i+inc);
            futureForb.add(j);
            if (!forb.contains(futureForb)) {
                dist = recFind(mat, i + inc, j, counter + 1, forb);
                if (counter == 0) {
                    forb.clear();
                    forb.add(new ArrayList<Integer>(Arrays.asList(i, j)));
                }
                if (dist == counter + 2) return counter+2;
                if (dist != -1) distArr.add(dist);
            }
        }

        int low = mat.length * 2;
        for (int c = 0; c<distArr.size(); c++) {
            if (distArr.get(c) < low) low = distArr.get(c);
        }

        return low;
    }

    public boolean isValid(int[][] mat, int i, int j) {
        return i >= 0 && i < mat.length && j >= 0 && j < mat[i].length;
    }

    public static void main(String[] args) {
        int[][] mat = {{0,0,0},
                       {0,1,0},
                       {0,0,0}};

        int[][] mat1 = {{0,0,0},
                        {0,1,0},
                        {1,1,1}};

        int[][] mat2 = {{1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                        {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                        {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                        {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                        {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                        {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                        {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                        {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                        {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};

        int[][] mat3 = {{1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                        {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                        {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                        {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                        {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                        {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                        {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                        {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                        {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};

        int[][] mat4 = {{1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                        {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                        {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                        {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                        {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                        {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                        {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                        {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                        {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};

        OMatrix solver = new OMatrix();

        System.out.println("first matrix:");
        System.out.println(Arrays.deepToString(solver.updateMatrix(mat)));
        System.out.println();

        System.out.println("second matrix:");
        System.out.println(Arrays.deepToString(solver.updateMatrix(mat1)));
        System.out.println();

        System.out.println("third matrix:");
        System.out.println(Arrays.deepToString(solver.updateMatrix(mat2)));
        System.out.println();

        System.out.println("fourth matrix");
        System.out.println(Arrays.deepToString(solver.updateMatrix(mat3)));
        System.out.println();

        System.out.println("fifth matrix");
        System.out.println(Arrays.deepToString(solver.updateMatrix(mat4)));
        System.out.println();
    }
}
