package DP.knapsack;

import java.util.Arrays;

public class RodCutting {
    // weight => length; val => price; W = totRod
    // same as unbounded knapsacks we can take cut same length multiple times

    private static int memo(int n, int length[], int price[], int totRod, int dp[][]) {
        if (n < 0) {
            return 0;
        }

        if (totRod == 0 || n == 0) {
            return 0;
        }
        if (dp[n][totRod] != -1) {
            return dp[n][totRod];
        }

        if (totRod >= length[n - 1]) {
            int cut = price[n - 1] + memo(n, length, price, totRod - length[n - 1], dp);
            int noCut = memo(n - 1, length, price, totRod, dp);
            return dp[n][totRod] = Math.max(cut, noCut);
        } else {
            return dp[n][totRod] = memo(n - 1, length, price, totRod, dp);
        }
    }

    public static int rodCutting2(int length[], int price[], int totRod) {
        int n = price.length;
        int dp[][] = new int[n + 1][totRod + 1];

        for (int memo[] : dp) {
            Arrays.fill(memo, -1);
        }

        return memo(n, length, price, totRod, dp);
    }

    public static int rodCutting(int length[], int price[], int totRod) {
        int n = price.length;
        int dp[][] = new int[n + 1][totRod + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < totRod + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < totRod + 1; j++) {
                // valid
                if (length[i - 1] <= j) {
                    // dp[i][j] = Math.max(val[i-1] + dp[i][j-wt[i-1]] , dp[i-1][j])
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][totRod];
    }


    //GFG
    public int cutRod(int[] price) {
        int n = price.length;
        int length[] = new int[n];
        for (int i = 0; i < n; i++) {
            length[i] = i + 1;
        }

        int dp[][] = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (j >= length[i - 1]) {
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][n];
    }

}

    public static void main(String[] args) {
        int length[] = { 1, 2, 3 };
        int price[] = { 2, 5, 8 };
        int totRod = 3;
        System.out.println(rodCutting2(length, price, totRod));
    }
}
