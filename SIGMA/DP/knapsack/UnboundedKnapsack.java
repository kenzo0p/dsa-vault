package DP.knapsack;

import java.util.Arrays;

public class UnboundedKnapsack {

    private static int solve(int capacity, int n, int val[], int wt[], int dp[][]) {
        if (capacity == 0 || n == 0) {
            return 0;
        }

        if (dp[n][capacity] != -1) {
            return dp[n][capacity];
        }

        if (wt[n - 1] <= capacity) {
            int take = val[n - 1] + solve(capacity - wt[n - 1], n, val, wt, dp);
            int notTake = solve(capacity, n - 1, val, wt, dp);
            return dp[n][capacity] = Math.max(take, notTake);
        } else {
            return dp[n][capacity] = solve(capacity, n - 1, val, wt, dp);
        }
    }

    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = val.length;
        int dp[][] = new int[n + 1][capacity + 1];

        for (int memo[] : dp) {
            Arrays.fill(memo, -1);
        }

        return solve(capacity, n, val, wt, dp);
    }

    // o(n*w)
    public static int unboundedKnapsack(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < W + 1; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (wt[i - 1] <= j) { // valid
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                } else { // invalid
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        System.out.println(unboundedKnapsack(val, wt, W));
    }

}
