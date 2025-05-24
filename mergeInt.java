import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] last = res.get(res.size() - 1);
            int[] adding = intervals[i];

            if (last[1] < adding[0])
                res.add(adding);
            else
                last[1] = Math.max(last[1], adding[1]);
        }

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] intervals1 = {{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals2 = {{1,4},{4,5}};
        System.out.println(Arrays.deepToString(sol.merge(intervals1)));
        System.out.println(Arrays.deepToString(sol.merge(intervals2)));
    }
}
