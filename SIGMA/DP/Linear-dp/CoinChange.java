package DP.Linear

import java.util.Arrays;

///remember unbounded knpasaack problem 
 
//tc -> o(amount  * coin) sc = o(amount)


  private int memo(int n, int coins[], int amount, int dp[][]) {
        if (amount == 0) return 0;
        if (n == 0) return Integer.MAX_VALUE;

        if (dp[n][amount] != -1) return dp[n][amount];

        int ans = Integer.MAX_VALUE;

        if (coins[n-1] <= amount) {
            int take = memo(n, coins, amount - coins[n-1], dp); // unbounded
            if (take != Integer.MAX_VALUE) {
                ans = take + 1;
            }
        }

        int notTake = memo(n-1, coins, amount, dp);

        ans = Math.min(ans, notTake);
        dp[n][amount] = ans;
        return ans;
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n+1][amount+1];
        for (int num[] : dp) {
            Arrays.fill(num, -1);
        }
        int ans = memo(n, coins, amount, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }


public class CoinChange {
    public int memo(int amount, int coins[], int[] dp) {
        if (amount == 0)
            return 0;
        if (dp[amount] != -1)
            return dp[amount];
        int minCoins = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) { // har level pe 3 choices le rahe hain
                minCoins = Math.min(minCoins, memo(amount - coins[i], coins, dp));

            }
        }

        if (minCoins < Integer.MAX_VALUE)
            minCoins += 1;

        return dp[amount] = minCoins;
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int ans = memo(amount, coins, dp);
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    public int memo2(int amount, int idx, int coins[], int dp[][]) {
        if (amount < 0)
            return Integer.MAX_VALUE;
        if (amount == 0)
            return 0;
        if (idx == coins.length)
            return Integer.MAX_VALUE;
        if (dp[amount][idx] != -1)
            return dp[amount][idx];

        int yes = memo2(amount - coins[idx], idx, coins, dp);
        if (yes != Integer.MAX_VALUE)
            yes += 1;
        int no = memo2(amount, idx + 1, coins, dp);
        return dp[amount][idx] = Math.min(yes, no);

    }

    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[amount + 1][coins.length];
        for (int memo[] : dp) {
            Arrays.fill(memo, -1);
        }

        int ans = memo2(amount, 0, coins, dp);
        if (ans == Integer.MAX_VALUE)
            return -1;
        return ans;
    }

    // bottom up -> tc (o(amount * coin)) space -> o(amount)
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

}
