class Solution {
    public int countGoodNumbers(long n) {
        long odd = (n - (n % 2)) / 2;
        long even = n - odd;

        long MOD = 1000000007;
        return (int) ((fastPower(4, odd) * fastPower(5, even)) % MOD);
    }

    public static long fastPower(long base, long exponent) {
        long MOD = 1000000007;
        long result = 1;
        base %= MOD;

        while (exponent > 0) {
            if ((exponent & 1) == 1) { // If exponent is odd
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exponent >>= 1; // Divide exponent by 2
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.countGoodNumbers(50));
    }
}
