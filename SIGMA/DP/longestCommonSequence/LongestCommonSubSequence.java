package DP.longestCommonSequence;

public class LongestCommonSubSequence {
    // using recursion
    public static int rec(String str1, String str2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {// same
            return rec(str1, str2, n - 1, m - 1) + 1;
        } else { // diff
            int ans1 = rec(str1, str2, n - 1, m);
            int ans2 = rec(str1, str2, n, m - 1);
            return Math.max(ans1, ans2);
        }
    }

    // using memo rows n cols m => o(n*m)
    public static int memo(String str1, String str2, int n, int m, int dp[][]) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != 0) {
            return dp[n][m];
        }
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {// same
            return dp[n][m] = rec(str1, str2, n - 1, m - 1) + 1;
        } else { // diff
            int ans1 = memo(str1, str2, n - 1, m, dp);
            int ans2 = memo(str1, str2, n, m - 1, dp);
            return dp[n][m] = Math.max(ans1, ans2);
        }
    }

    // using tabulation
    public static int tabulation(String str1, String str2, int n, int m, int dp[][]) {
        if (n == 0 || m == 0) {
            return 0;
        }

        // there is no need in initi in java (0 its already 0) just for concept clearing
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {// same
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else { // diff
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }

            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg";
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
        System.out.println(tabulation(str1, str2, n, m, dp));
    }
}
