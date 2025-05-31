// [https://leetcode.com/problems/subsets-ii/description/]

import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subsetdfs(nums, res, new ArrayList<>(), 0);
        return res;
    }

    public void subsetdfs(int[] nums, List<List<Integer>> res, List<Integer> building, int i) {
        building.sort(null);
        if (!res.contains(building))
            res.add(building);

        if (i >= nums.length)
            return;

        List<Integer> without = new ArrayList<>();
        without.addAll(building);

        List<Integer> with = new ArrayList<>();
        with.addAll(building);
        with.add(nums[i]);

        subsetdfs(nums, res, without, i + 1);
        subsetdfs(nums, res, with, i + 1);
    }

    public static void main(String[] args) {
        int[] in1 = new int[]{1, 2, 2};

        List<List<Integer>> o1 = new ArrayList<>(
                Arrays.asList(new ArrayList<Integer>(), new ArrayList<Integer>(Arrays.asList(1)),
                        new ArrayList<Integer>(Arrays.asList(2)), new ArrayList<Integer>(Arrays.asList(1, 2)),
                        new ArrayList<Integer>(Arrays.asList(2, 2)), new ArrayList<Integer>(Arrays.asList(1, 2, 2))));

        Solution sol = new Solution();
        List<List<Integer>> res = sol.subsetsWithDup(in1);

        for (List<Integer> list : o1) {
            if (!res.contains(list)) {
                // print the list that is not found
                System.out.println("Test failed: " + list + " not found in result");
                System.out.println("Expected: " + o1);
                return;
            }
        }
    }
}
