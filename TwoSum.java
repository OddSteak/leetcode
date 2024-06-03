import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0; i<nums.length; i++) {
            for(int j = i+1; j<nums.length; j++) {
                if(nums[i] + nums[j] == target)
                    return new int[] {i, j};
            }
        }
        return new int[] {0, 0};
    }

    public static void main(String[] args) {
        int[] res = TwoSum.twoSum(
                            new int[]{2,7,11,15}, 9);
        int[] res2 = TwoSum.twoSum(
                            new int[]{3,2,4}, 6);
        int[] res3 = TwoSum.twoSum(
                            new int[]{3,3}, 6);

        for(int i = 0; i<res.length; i++) {
            System.out.print(res[i]+" ");
        }
        for(int i = 0; i<res.length; i++) {
            System.out.print(res2[i]+" ");
        }
        for(int i = 0; i<res.length; i++) {
            System.out.print(res3[i]+" ");
        }
    }
}

