package SIGMA.DP.Dp_on_grids;

import java.util.Arrays;
import java.util.HashMap;

public class DungeanGame {
    private int m;
    private int n;

    private boolean cansurvive(int i, int j, int mid, int dungeon[][]) {
        if (i >= m || j >= n) {
            return false;
        }

        mid += dungeon[i][j];
        if (mid <= 0) {
            return false;
        }
        if (i == m - 1 && j == n - 1) {
            return true;
        }

        return cansurvive(i, j + 1, mid, dungeon) || cansurvive(i + 1, j, mid, dungeon);
    }

    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;
        n = dungeon[0].length;

        int left = 1;
        int right = 4 * (int) 1e7;

        int minHealth = 4 * (int) 1e7;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (cansurvive(0, 0, mid, dungeon)) {
                minHealth = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return minHealth;
    }

    // using memoizzation in same approach

    private int m;
    private int n;
    private HashMap<String, Boolean> mp = new HashMap<>();

    private boolean cansurvive(int i, int j, int mid, int dungeon[][]) { // mid i.e current health
        if (i >= m || j >= n) {
            return false;
        }

        mid += dungeon[i][j];
        if (mid <= 0) {
            return false;
        }
        if (i == m - 1 && j == n - 1) {
            return true;
        }

        String key = i + "_" + j + "_" + mid;
        if (mp.containsKey(key)) {
            return mp.get(key);
        }

        boolean canSearch = cansurvive(i, j + 1, mid, dungeon) || cansurvive(i + 1, j, mid, dungeon);
        mp.put(key, canSearch);
        return canSearch;
    }

    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;
        n = dungeon[0].length;

        int left = 1;
        int right = 4 * (int) 1e7;

        int minHealth = 4 * (int) 1e7;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (cansurvive(0, 0, mid, dungeon)) {
                minHealth = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return minHealth;
    }

    // recursion and memoization o(m*n)
    private int m;
    private int n;
    private int t[][] = new int[201][201];

    private int solve(int i, int j, int[][] dungeon) {
        if (i >= m | j >= n) {
            return Integer.MAX_VALUE;
        }

        if (t[i][j] != -1) {
            return t[i][j];
        }

        if (i == m - 1 && j == n - 1) {
            if (dungeon[i][j] > 0) {
                return 1;
            }

            return Math.abs(dungeon[i][j]) + 1;
        }

        int right = solve(i, j + 1, dungeon);
        int down = solve(i + 1, j, dungeon);

        int result = Math.min(right, down) - dungeon[i][j];

        return t[i][j] = (result > 0) ? result : 1;

    }

    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;
        n = dungeon[0].length;
        for (int m[] : t) {
            Arrays.fill(m, -1);
        }
        return solve(0, 0, dungeon);
    }

    // using bottom up

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int t[][] = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    t[i][j] = dungeon[i][j] > 0 ? 1 : Math.abs(dungeon[i][j]) + 1;
                } else {
                    int down = (i + 1 >= m ? Integer.MAX_VALUE : t[i + 1][j]);
                    int right = (j + 1 >= n ? Integer.MAX_VALUE : t[i][j + 1]);
                    int result = Math.min(down, right) - dungeon[i][j];

                    t[i][j] = (result > 0 ? result : 1);
                }
            }
        }

        return t[0][0]; // min health req to reach m-1 and n-1 from (0, 0)
    }
}
