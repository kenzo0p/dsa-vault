package DP.longestCommonSequence;

import java.util.Arrays;

public class BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons {

    /*
     * leetco de 1420
     * 
     * 
     */
    private int N, M, K;
    private final int MOD = 1000000007;
    private int[][][] t = new int[51][51][101];
    // O(m*n*k)
    private int solve(int idx, int searchCost, int maxSoFar) {
        if (idx == N) {
            if (searchCost == K) {
                return 1;
            }
            return 0;
        }
        if (t[idx][searchCost][maxSoFar] != -1) {
            return t[idx][searchCost][maxSoFar];
        }
        int result = 0;
        for (int i = 1; i <= M; i++) {
            if (i > maxSoFar) {
                result = (result + solve(idx + 1, searchCost + 1, i)) % MOD;
            } else {
                result = (result + solve(idx + 1, searchCost, maxSoFar)) % MOD;
            }
        }
        return t[idx][searchCost][maxSoFar] = result % MOD;

    }

    public int numOfArrays(int n, int m, int k) {
        N = n;
        M = m;
        K = k;

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                Arrays.fill(t[i][j], -1); // Fill the 1D array at level dp[i][j]
            }
        }
        return solve(0, 0, 0);
    }

}
