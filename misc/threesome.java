import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int target, right, left;
        List<List<Integer>> retArr = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0 && nums[i - 1] == nums[i])
                continue;

            target = -nums[i];
            right = nums.length - 1;
            left = i + 1;

            while (left < right) {
                if (nums[left] + nums[right] < target) {
                    left++;
                    continue;
                }

                if (nums[left] + nums[right] > target) {
                    right--;
                    continue;
                }

                List<Integer> arr = Arrays.asList(nums[i], nums[left++], nums[right--]);
                if (retArr.size() == 0 || !arr.equals(retArr.get(retArr.size() - 1)))
                    retArr.add(arr);
            }
        }

        return retArr;
    }
}
