import java.util.Arrays;

class Solution {
    public int compress(char[] chars) {
        int idx = 0;

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            int c = 0;

            while (i < chars.length && chars[i] == ch) {
                c++;
                i++;
            }

            chars[idx++] = ch;

            if (c > 1) {
                for (char dig : Integer.toString(c).toCharArray()) {
                    chars[idx++] = dig;
                }
            }
            i--;
        }

        return idx;
    }

    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};
        char[] chars1 = {'a'};
        char[] chars2 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};

        /*
        char[] ans = {'a','2','b','2','c','3'};
        char[] ans1 = {'a'};
        char[] ans2 = {'a','b','1','2'};
        */

        int c = 6, c1 = 1, c2 = 4;

        Solution sol = new Solution();
        assert sol.compress(chars) == c;
        System.out.println(Arrays.toString(chars));

        assert sol.compress(chars1) == c1;
        System.out.println(Arrays.toString(chars1));

        assert sol.compress(chars2) == c2;
        System.out.println(Arrays.toString(chars2));
    }
}
