// [https://leetcode.com/problems/combination-sum-ii/description/]
package backtracking;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(candidates, target, res, current, 0, 0);

        return res;
    }

    public void backtrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> current, int i,
            int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(current));
            return;
        }

        else if (sum < target) {
            int prev = -1;
            for (int j = i; j < candidates.length; j++) {
                if (candidates[j] == prev) continue;
                if (sum + candidates[j] > target) break;

                current.add(candidates[j]);
                backtrack(candidates, target, res, current, j + 1, sum + candidates[j]);
                current.remove(current.size() - 1);

                prev = candidates[j];
            }
        }
    }
}
