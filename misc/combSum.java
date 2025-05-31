import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        return dfs(candidates, target, res, current, 0, 0);
    }

    public List<List<Integer>> dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> current, int i, int sum) {
        if (sum == target)
            res.add(new ArrayList<>(current));

        else if (sum < target) {
            for (int j = i; j < candidates.length; j++) {
                current.add(candidates[j]);
                dfs(candidates, target, res, current, j, sum + candidates[j]);
                current.remove(current.size() - 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.combinationSum(new int[]{2, 3, 6, 7}, 7).toArray()));
        System.out.println(Arrays.toString(sol.combinationSum(new int[]{2, 3, 5}, 8).toArray()));
        System.out.println(Arrays.toString(sol.combinationSum(new int[]{2}, 1).toArray()));
    }
}
