package slidingwin;
// [https://leetcode.com/problems/permutation-in-string/description/]

import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int start = 0;
        int end = s1.length() - 1;

        int[] a1 = freq(s1, 0, s1.length());
        int[] a2 = freq(s2, start, end + 1);

        // while the window is within the string
        while (true) {
            if (Arrays.equals(a1, a2))
                return true;

            // break if next iteration is outside the window
            if (end + 1 >= s2.length())
                break;

            // update the frequency list
            a2[Integer.valueOf(s2.charAt(start)) - Integer.valueOf('a')] -= 1;
            a2[Integer.valueOf(s2.charAt(end + 1)) - Integer.valueOf('a')] += 1;

            start++;
            end++;
        }

        return false;
    }

    public int[] freq(String s, int start, int end) {
        int[] res = new int[26];

        for (int i = start; i < end; i++) {
            res[Integer.valueOf(s.charAt(i)) - Integer.valueOf('a')] += 1;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s1 = "ab";
        String s2 = "eidbaooo";

        assert sol.checkInclusion(s1, s2);

        String s3 = "ab";
        String s4 = "eidboaoo";

        assert !sol.checkInclusion(s3, s4);

        String s5 = "hello";
        String s6 = "ooolleoooleh";

        assert !sol.checkInclusion(s5, s6);

        String s7 = "adc";
        String s8 = "dcda";

        assert sol.checkInclusion(s7, s8);
    }
}
