class Solution {
    public int myAtoi(String s) {
        String res = "";

        // search flags
        boolean ini = true;
        boolean signs = true;

        boolean sign = true;
        char cur;

        for (int i = 0; i < s.length(); i++) {
            cur = s.charAt(i);

            if ((cur <= 122 && cur >= 65) || cur == '.') break;

            if (cur == ' ') {
                if (ini) continue;
                break;
            }

            if (cur == '+' || cur == '-') {
                if (!signs) break;
                sign = cur == '+';
                signs = false;
                continue;
            }

            if (ini && cur == '0') continue;

            ini = false;
            res += cur;
        }

        System.out.println(res);
        return convert(res, sign);
    }

    public int convert(String s, boolean sign) {
        int num = 0;

        for (int i = s.length() - 1; i >= 0; i--)
            num += (s.charAt(i) - 48) * Math.pow(10, s.length() - i - 1);

        return sign ? num : -num;
    }

    public static void main(String[] args) {
        String s = "42";
        String s1 = "-042";
        String s2 = "1337c0d3";
        String s3 = "0-1";
        String s4 = "words and 987";

        Solution sol = new Solution();

        assert sol.myAtoi(s) == 42;
        assert sol.myAtoi(s1) == -42;
        assert sol.myAtoi(s2) == 1337;
        assert sol.myAtoi(s3) == 0;
        assert sol.myAtoi(s4) == 0;
    }
}
