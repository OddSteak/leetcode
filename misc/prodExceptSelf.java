import java.util.*;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pref = new int[nums.length];
        int[] suf = new int[nums.length];
        int[] res = new int[nums.length];

        pref[0] = nums[0];
        suf[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            pref[i] = pref[i - 1] * nums[i];
            suf[nums.length - 1 - i] = suf[nums.length - i] * nums[nums.length - 1 - i];
        }

        res[0] = suf[1];
        res[nums.length - 1] = pref[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++)
            res[i] = pref[i - 1] * suf[i + 1];

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
