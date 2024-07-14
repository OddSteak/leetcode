class LongPal {
    public int longestPalindrome(String s) {
        int[] ascii = new int[52];
        char ch;
        int count = 0;
        boolean spare = false;

        for (int i = 0; i<s.length(); i++) {
            ch = s.charAt(i);

            if (ch >= 65 && ch<=90) {
                ascii[26 + ch - 'A']++;
            } else ascii[ch - 'a']++;
        }

        for (int i = 0; i<ascii.length; i++) {
            if (ascii[i] % 2==0) count+=ascii[i];
            else {
                spare = true;
                count += ascii[i]-1;
            }
        }

        if (spare) return ++count;
        return count;
    }
}

