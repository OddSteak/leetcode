class Palindrome {
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();

        int low = 0;
        int high = s.length() - 1;

        while(true) {
            char lowChar = s.charAt(low);
            char highChar = s.charAt(high);

            if (low>=high) break;

            if (!Character.isLetterOrDigit(lowChar) ||
                lowChar == ' ') {
                low++; continue;
            }

            if (!Character.isLetterOrDigit(highChar) ||
                highChar == ' ') {
                high--; continue;
            }

            if (highChar != lowChar ) return false;
            high--; low++;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("A ran, a plan, a canal: Panama"));
    }
}
