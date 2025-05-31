class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int nneg = 0;
        long snum = Integer.MAX_VALUE;
        boolean zer = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0)
                    zer = true;

                if (Math.abs(matrix[i][j]) < snum)
                    snum = Math.abs(matrix[i][j]);

                if (matrix[i][j] < 0)
                    nneg++;

                sum += Math.abs(matrix[i][j]);
            }
        }

        if (nneg % 2 == 0 || zer)
            return sum;

        return sum - 2 * snum;
    }
}
