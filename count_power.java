class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        int si = Integer.parseInt(s);
        if (si > finish)
            return 0;


        return 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        assert sol.numberOfPowerfulInt(1, 6000, 4, "124") == 5;
        assert sol.numberOfPowerfulInt(15, 215, 6, "10") == 2;
        assert sol.numberOfPowerfulInt(1000, 2000, 4, "3000") == 0;
    }
}
