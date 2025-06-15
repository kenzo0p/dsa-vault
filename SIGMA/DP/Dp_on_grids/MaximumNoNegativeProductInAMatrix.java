package SIGMA.DP.Dp_on_grids;

public class MaximumNoNegativeProductInAMatrix {
    int m, n;
    final int MOD = 1000000007;

    // Memoization table for storing (max, min) pairs
    Pair<Long, Long>[][] t;

    public Pair<Long, Long> solve(int i, int j, int[][] grid) {
        // Base case: If we're at the bottom-right corner, return the value
        if (i == m - 1 && j == n - 1) {
            return new Pair<>((long) grid[i][j], (long) grid[i][j]);
        }

        long maxVal = Long.MIN_VALUE;
        long minVal = Long.MAX_VALUE;

        // If already computed, return the memoized result
        if (t[i][j] != null) {
            return t[i][j];
        }

        // Move down
        if (i + 1 < m) {
            Pair<Long, Long> down = solve(i + 1, j, grid);
            maxVal = Math.max(maxVal, Math.max(grid[i][j] * down.getKey(), grid[i][j] * down.getValue()));
            minVal = Math.min(minVal, Math.min(grid[i][j] * down.getKey(), grid[i][j] * down.getValue()));
        }

        // Move right
        if (j + 1 < n) {
            Pair<Long, Long> right = solve(i, j + 1, grid);
            maxVal = Math.max(maxVal, Math.max(grid[i][j] * right.getKey(), grid[i][j] * right.getValue()));
            minVal = Math.min(minVal, Math.min(grid[i][j] * right.getKey(), grid[i][j] * right.getValue()));
        }

        // Memoize results
        t[i][j] = new Pair<>(maxVal, minVal);

        return t[i][j];
    }

    public int maxProductPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        // Initialize the memoization table
        t = new Pair[m][n];

        // Get the result from the top-left corner
        Pair<Long, Long> result = solve(0, 0, grid);

        // If the result is negative, return -1, otherwise return the result modulo MOD
        return result.getKey() < 0 ? -1 : (int) (result.getKey() % MOD);
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
