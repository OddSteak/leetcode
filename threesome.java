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
                if ((left - 1 != i && nums[left - 1] == nums[left]) || nums[left] + nums[right] < target) {
                    left++;
                    continue;
                }

                if ((right + 1 < nums.length && nums[right + 1] == nums[right]) || nums[left] + nums[right] > target) {
                    right--;
                    continue;
                }

                List<Integer> arr = new ArrayList<>(Arrays.asList(nums[i], nums[left++], nums[right--]));
                retArr.add(arr);
            }
        }

        return retArr;
    }
}
