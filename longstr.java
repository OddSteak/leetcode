import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int right = 0;
        int left = 0;
        Set<Character> hst = new HashSet<>();

        if (s.length() == 0)
            return 0;

        while (true) {
            if (right == s.length() - 1)
                return right - left + 1 > max ? right - left + 1 : max;

            hst.add(s.charAt(right++));

            if (hst.contains(s.charAt(right))) {
                max = right - left > max ? right - left : max;
                do {
                    hst.remove(s.charAt(left));
                } while (s.charAt(left++) != s.charAt(right));
            }

        }
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.format("final result is %d\n", obj.lengthOfLongestSubstring(" "));
    }
}
