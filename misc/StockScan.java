public class StockScan {
    public int maxProfit(int[] prices) {
        int low = prices[0];
        int prof = 0;

        for (int i = 1; i<prices.length; i++) {
            if(prices[i] < low) {
                low = prices[i];
                continue;
            }
            if(prices[i] - low > prof) prof = prices[i]-low;
        }

        return prof;
    }
}
