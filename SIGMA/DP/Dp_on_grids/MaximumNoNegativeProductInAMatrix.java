package SIGMA.DP.Dp_on_grids;
import java.util.*;
public class MaximumNoNegativeProductInAMatrix {
    private static final int MOD = (int)1e9 + 7;
    private long[][][] memo;  // memo[i][j][0] = min, memo[i][j][1] = max
    private int m, n;

    private long[] solve(int i, int j, int[][] grid) {
        if (i == m - 1 && j == n - 1) {
            long val = grid[i][j];
            return new long[]{val, val}; // min = max = cell value
        }

        if (memo[i][j][0] != Long.MAX_VALUE) {
            return new long[]{memo[i][j][0], memo[i][j][1]};
        }

        long minVal = Long.MAX_VALUE;
        long maxVal = Long.MIN_VALUE;

        // move down
        if (i + 1 < m) {
            long[] down = solve(i + 1, j, grid);
            minVal = Math.min(minVal, grid[i][j] * down[0]);
            minVal = Math.min(minVal, grid[i][j] * down[1]);
            maxVal = Math.max(maxVal, grid[i][j] * down[0]);
            maxVal = Math.max(maxVal, grid[i][j] * down[1]);
        }

        // move right
        if (j + 1 < n) {
            long[] right = solve(i, j + 1, grid);
            minVal = Math.min(minVal, grid[i][j] * right[0]);
            minVal = Math.min(minVal, grid[i][j] * right[1]);
            maxVal = Math.max(maxVal, grid[i][j] * right[0]);
            maxVal = Math.max(maxVal, grid[i][j] * right[1]);
        }

        memo[i][j][0] = minVal;
        memo[i][j][1] = maxVal;
        return new long[]{minVal, maxVal};
    }

    public int maxProductPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        memo = new long[m][n][2];

        // initialize memo
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j][0] = Long.MAX_VALUE;
                memo[i][j][1] = Long.MIN_VALUE;
            }
        }

        long[] ans = solve(0, 0, grid);
        return ans[1] < 0 ? -1 : (int)(ans[1] % MOD);
    }

    // Bottom up
    final int MOD = 1000000007;

    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Initialize the DP table
        Pair<Long, Long>[][] t = new Pair[m][n];

        // Base case: starting point
        t[0][0] = new Pair<>((long) grid[0][0], (long) grid[0][0]);

        // Fill the first row
        for (int j = 1; j < n; j++) {
            t[0][j] = new Pair<>(t[0][j - 1].getKey() * grid[0][j], t[0][j - 1].getValue() * grid[0][j]);
        }

        // Fill the first column
        for (int i = 1; i < m; i++) {
            t[i][0] = new Pair<>(t[i - 1][0].getKey() * grid[i][0], t[i - 1][0].getValue() * grid[i][0]);
        }

        // Fill the rest of the DP table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long upMax = t[i - 1][j].getKey();
                long upMin = t[i - 1][j].getValue();

                long leftMax = t[i][j - 1].getKey();
                long leftMin = t[i][j - 1].getValue();

                t[i][j] = new Pair<>(
                        Math.max(Math.max(upMax * grid[i][j], upMin * grid[i][j]),
                                Math.max(leftMax * grid[i][j], leftMin * grid[i][j])),
                        Math.min(Math.min(upMax * grid[i][j], upMin * grid[i][j]),
                                Math.min(leftMax * grid[i][j], leftMin * grid[i][j])));
            }
        }

        // Get the result from the bottom-right corner
        long maxProd = t[m - 1][n - 1].getKey();

        // If the result is negative, return -1, otherwise return the result modulo MOD
        return maxProd < 0 ? -1 : (int) (maxProd % MOD);
    }
}
