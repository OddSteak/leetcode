import java.util.*;
class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int max = 0, left = 0, right = 0;
        HashSet<Character> hst = new HashSet<>();

        while (true) {
            if (right == s.length() - 1) {
                return right - left + 1 > max ? right - left + 1 : max;
            }

            hst.add(s.charAt(right++));

            if (hst.contains(s.charAt(right))) {
                if (right - left + 1 > max) {
                    max = right - left + 1;
                }

                do {
                    hst.remove(s.charAt(left));
                } while (s.charAt(left++) != s.charAt(right));
            }
        }
    }

    public static String brute(String s) {
        String lstr = "";
        int l = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int low = i;
                int high = j;
                boolean isp = true;

                while (low < high) {
                    if (s.charAt(low) != s.charAt(high)) {
                        isp = false;
                        break;
                    }
                    low++;
                    high--;
                }

                if (isp && j - i + 1 > l) {
                    l = j - i + 1;
                    lstr = s.substring(i, j + 1);
                }
            }
        }

        return lstr;
    }

    public static void main(String[] args) {
        System.out.println(brute("cbbd"));
    }
}
