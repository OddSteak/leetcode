import java.util.*;

class Solution {
    public static int coinChange(int[] coins, int amount) {
        return iterDp(coins, amount);
    }

    public static int iterDp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static int recDp(int[] coins, int amount) {
        HashMap<Integer, Integer> hmp = new HashMap<>();
        return coinCount(coins, amount, hmp);
    }

    public static int coinCount(int[] coins, int amount, HashMap<Integer, Integer> hmp) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;
        if (hmp.containsKey(amount))
            return hmp.get(amount);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int res = coinCount(coins, amount - coins[i], hmp);
            if (res != -1)
                min = Math.min(min, res + 1);
        }

        hmp.put(amount, min == Integer.MAX_VALUE ? -1 : min);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[] { 186, 419, 83, 408 }, 6249));
    }
}
