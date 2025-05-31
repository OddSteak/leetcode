class Solution {
    public static int majorityElement(int[] nums) {
        int ele = nums[0];
        int count = 0;
        // 2, 2, 1, 1, 1, 3, 3

        for (int i = 0; i<nums.length; i++) {
            if (count ==  0) ele = nums[i];

            if (ele == nums[i]) count++;

            else count--;
        }

        return ele;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 3, 3};

        System.out.println(majorityElement(arr));
    }
}
