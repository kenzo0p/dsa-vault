package SIGMA.DP.buyandsellstocks;

public class buyAndSellStocksII {
    private static int rec(int i, int buyStatus, int prices[], int dp[][]) {
        if (i == prices.length) {
            return 0;
        }
        if (dp[i][buyStatus] != -1) {
            return dp[i][buyStatus];
        }
        int ans = 0;
        if (buyStatus == 0) {
            int skip = rec(i + 1, 0, prices, dp);
            int take = -prices[i] + rec(i + 1, 1, prices, dp);
            ans = Math.max(skip, take);
        } else {
            int skip = rec(i + 1, 1, prices, dp);
            int sell = prices[i] + rec(i + 1, 0, prices, dp);
            ans = Math.max(skip, sell);
        }
        dp[i][buyStatus] = ans;
        return ans;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = -1;
            }
        }
        return rec(0, 0, prices, dp);
    }


      public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=1; i<prices.length; i++){
           int cur = prices[i];
           int prev = prices[i-1];
           if(prev < cur) profit = profit + cur - prev;
        }

        return profit;
    }
    
}
