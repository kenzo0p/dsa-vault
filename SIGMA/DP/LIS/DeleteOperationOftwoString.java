package LIS;

import java.util.Arrays;

public class DeleteOperationOftwoString {

    private int t[][] = new int[501][501];

    private int solve(int m, int n, String word1, String word2) {
        if (m == 0 || n == 0) {
            return m + n;
        }

        if (t[m][n] != -1) {
            return t[m][n];
        }

        if (word1.charAt(m - 1) == word2.charAt(n - 1)) {
            return solve(m - 1, n - 1, word1, word2);
        } else {
            return t[m][n] = 1 + Math.min(solve(m - 1, n, word1, word2), solve(m, n - 1, word1, word2));
        }

    }

    public int minDistance(String word1, String word2) {
        for (int d[] : t) {
            Arrays.fill(d, -1);
        }
        int m = word1.length();
        int n = word2.length();
        return solve(m, n, word1, word2);
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int t[][] = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = i + j;
                } else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        t[i][j] = t[i - 1][j - 1];
                    } else {

                        t[i][j] = 1 + Math.min(t[i - 1][j], t[i][j - 1]);
                    }
                }
            }
        }
        return t[m][n];
    }

}
