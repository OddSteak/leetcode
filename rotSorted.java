class Solution {
    public int search(int[] nums, int target) {
        int piv = pivot(nums);
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int converted = convert(nums, mid, piv);

            if (nums[converted] == target)
                return converted;

            if (nums[converted] > target)
                high = mid - 1;

            if (nums[converted] < target)
                low = mid + 1;
        }

        return -1;
    }

    public int pivot(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (nums[0] > nums[mid]) {
                if (nums[mid - 1] >= nums[0])
                    return mid;

                high = mid - 1;
            }

            if (nums[0] <= nums[mid]) {
                low = mid + 1;
            }
        }

        return -1;
    }

    public int convert(int[] nums, int input, int pivot) {
        if (pivot == -1)
            return input;

        if (input < nums.length - pivot)
            return pivot + input;

        return input - (nums.length - pivot);
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int[] nums2 = {1, 2};
        int[] nums3 = {1};
        int[] nums4 = {3, 1};
        int t1 = 0, t2 = 3, t3 = 1;

        Solution sol = new Solution();
        System.out.println(sol.search(nums, t1));
        System.out.println(sol.search(nums, t2));

        System.out.println(sol.search(nums2, 2));

        System.out.println(sol.search(nums3, t1));
        System.out.println(sol.search(nums4, t3));
    }
}
