package lcs;

import java.util.Arrays;

public class ShortestCommonSuperSeq {
    private static int t[][] = new int[501][501];

    private static int solve(String s1, String s2, int m, int n) {
        if (m == 0) {
            return n;
        } else if (n == 0) {
            return m;
        }
        if (t[m][n] != -1) {
            return t[m][n];
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return t[m][n] = 1 + solve(s1, s2, m - 1, n - 1);
        } else {
            return t[m][n] = 1 + Math.min(solve(s1, s2, m - 1, n), solve(s1, s2, m, n - 1));
        }

    }

    public static int shortestCommonSupersequence(String s1, String s2) {
        // Your code here
        for (int dp[] : t) {
            Arrays.fill(dp, -1);
        }
        int m = s1.length();
        int n = s2.length();
        return solve(s1, s2, m, n);
    }

    //bottom up
    public static int shortestCommonSupersequence(String s1, String s2) {
        // Your code here
        int m = s1.length();
        int n = s2.length();
        int t[][] = new int[m + 1][n + 1];
        for (int dp[] : t) {
            Arrays.fill(dp, -1);
        }
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = i + j;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = 1 + Math.min(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        return t[m][n];
    }



    //using lcs
        public int shortestCommonSupersequence(String s1, String s2, int m, int n) {
        int[][] t = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    t[i][j] = 1 + t[i - 1][j - 1];
                else
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
            }
        }

        int LCS = t[m][n];

        int letters_from_s1 = m - LCS;
        int letters_from_s2 = n - LCS;

        return LCS + letters_from_s1 + letters_from_s2;
    }
}
