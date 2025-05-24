class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        Boolean[][] mem = new Boolean[nums.length][sum];

        if (sum % 2 == 1)
            return false;

        int target = sum / 2;

        return tdRec(nums, 0, target, mem);
    }

    public boolean tdRec(int[] nums, int index, int target, Boolean[][] mem) {
        if (target == 0)
            return true;
        if (target < 0 || index >= nums.length)
            return false;
        if (mem[index][target] != null)
            return mem[index][target];

        return mem[index][target] = tdRec(nums, index + 1, target - nums[index], mem) ||
                tdRec(nums, index + 1, target, mem);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = { 1, 5, 11, 5 };
        int[] nums1 = { 1, 2, 3, 5 };
        int[] nums2 = { 1, 2, 3, 4, 5, 6, 7 };

        assert sol.canPartition(nums);
        assert !sol.canPartition(nums1);
        assert sol.canPartition(nums2);
    }
}
