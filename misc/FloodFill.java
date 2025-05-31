class FloodFill {
     public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        int start = image[sr][sc];

        image[sr][sc] = color;


        int[] inc = {1, -1, 0, 0};

        int x, y;
        int low = 0; int high = 3;

        while(low<4) {
            x = sr + inc[low];
            y = sc + inc[high];

            if (x >= image.length ||
                x < 0 ||
                y < 0 ||
                y >= image[x].length) {
                low++; high--;
                continue;
            }

            if (image[x][y] == start) {
                floodFill(image, x, y, color);
            }

            low++; high--;

        }

        return image;
    }

    public static void main(String[] args) {
        floodFill(new int[][] {{1,1,1},{1,1,0},{1,0,1}},
                    1, 1, 2);
    }
}
