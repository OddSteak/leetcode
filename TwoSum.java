import java.util.HashMap;

/*
 * try with hashmap
*/
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        var hmp = new HashMap<Integer, Integer>(nums.length, 1);

        for(int i = 0; i<nums.length; i++) {
            if(hmp.containsKey(target - nums[i])) {
                return new int[] {hmp.get(target - nums[i]), i};
            }
            hmp.put(nums[i], i);
        }

        return new int[] {};
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

