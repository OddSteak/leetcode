class BinarySearch {
    public static int search(int[] nums, int target) {
        return recSearch(nums, target, 0, nums.length);
    }

    public static int recSearch(int[] nums, int target, int low, int high) {
        if (high - low == 1) return nums[low] == target ? low : -1;

        if ((high - low) % 2 != 0) {
            int mid = low+ (((high-low+1)/2) - 1);

            if(target == nums[mid]) return mid;

            if(target>nums[mid]) {
                return recSearch(nums, target, mid+1, high);
            }

            if(target<nums[mid]) {
                return recSearch(nums, target, low, mid);
            }
        } else {
            int mid = low + ((high-low)/2);

            if (target == nums[mid]) return mid;
            if(target>nums[mid]) {
                return recSearch(nums, target, mid, high);
            }

            if(target<nums[mid]) {
                return recSearch(nums, target, low, mid);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] {-1, 0, 3, 5, 9, 12}, 9 ));
    }
}
