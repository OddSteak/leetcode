// [https://leetcode.com/problems/subsets/description/]

import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new ArrayList<>(), 0);
        return res;
    }

    public void backtrack(int[] nums, List<List<Integer>> res, List<Integer> current, int idx) {
        res.add(new ArrayList<>(current));

        for (int i = idx; i < nums.length; i++) {
            current.add(nums[i]); // include i
            backtrack(nums, res, current, i + 1); // explore
            current.remove(current.size() - 1); // backtrack
        }
    }
}
