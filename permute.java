import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        dfs(nums, res, current, 0, visited);
        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> current, int i, boolean[] visited) {
        if (nums.length == current.size())
            res.add(new ArrayList<>(current));

        else {
            for (int j = 0; j < nums.length; j++) {
                if (visited[j] == false) {
                    current.add(nums[j]);
                    visited[j] = true;
                    dfs(nums, res, current, j, visited);
                    current.remove(current.size() - 1);
                    visited[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.permute(new int[]{1, 2, 3}).toArray()));
        System.out.println(Arrays.toString(sol.permute(new int[]{0, 1}).toArray()));
        System.out.println(Arrays.toString(sol.permute(new int[]{1}).toArray()));
    }
}
