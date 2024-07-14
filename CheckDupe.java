import java.util.Set;
import java.util.HashSet;

class CheckDupe {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hst = new HashSet<>();

        for (int i = 0; i<nums.length; i++) {
            if (!hst.add(nums[i])) return true;
        }

        return false;
    }
}
