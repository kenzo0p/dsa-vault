package SIGMA.DP.buyandsellstocks;

public class BuyandSellStocksIV {
    static int rec(int i, int buyStatus, int txn, int prices[], int dp[][][], int k) {
        if (i == prices.length || txn == k) {
            return 0;
        }

        if (dp[i][buyStatus][txn] != -1) {
            return dp[i][buyStatus][txn];
        }

        int ans = 0;

        if (buyStatus == 0) {
            int skip = rec(i + 1, 0, txn, prices, dp, k);
            int buy = -prices[i] + rec(i + 1, 1, txn, prices, dp, k);

            ans = Math.max(skip, buy);
        } else {
            int skip = rec(i + 1, 1, txn, prices, dp, k);
            int sell = prices[i] + rec(i + 1, 0, txn + 1, prices, dp, k);

            ans = Math.max(skip, sell);
        }
        dp[i][buyStatus][txn] = ans;
        return ans;
    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n][2][k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int x = 0; x < k; x++) {
                    dp[i][j][x] = -1;
                }
            }
        }

        return rec(0, 0, 0, prices, dp, k);
    }
}
