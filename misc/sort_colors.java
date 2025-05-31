class Solution {
    public void sortColors(int[] nums) {
        int n0 = 0, n1 = 0, n2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                n0++;
            if (nums[i] == 1)
                n1++;
            if (nums[i] == 2)
                n2++;
        }

        for (int i = 0; i < n0; i++)
            nums[i] = 0;
        for (int i = n0; i < n0 + n1; i++)
            nums[i] = 1;
        for (int i = n1 + n0; i < n0 + n1 + n2; i++)
            nums[i] = 2;
    }
}
