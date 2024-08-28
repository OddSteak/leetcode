import java.util.Arrays;

class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        for (int pivot = 0; pivot < numbers.length; pivot++) {
            for (int i = pivot + 1; i < numbers.length; i++) {
                int sum = numbers[i] + numbers[pivot];
                if (sum == target)
                    return new int[] { pivot + 1, i + 1 };
                if (sum > target)
                    break;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum2 s = new TwoSum2();
        assert Arrays.equals(s.twoSum(new int[] {2,3,4}, 6), new int[] {1, 3});
        assert Arrays.equals(s.twoSum(new int[] {1,2,3,4,5,8,10}, 10), new int[] { 2, 6 });
        assert Arrays.equals(s.twoSum(new int[] {2,7,11,15}, 13), new int[] {1, 3});
    }
}
