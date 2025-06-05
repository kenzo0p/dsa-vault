package lcs;

public class LongestCommonSubSequence {

    /*
     * 
     * 1143. Longest Common Subsequence
     * Given two strings text1 and text2, return the length of their longest common
     * subsequence. If there is no common subsequence, return 0.
     * 
     * A subsequence of a string is a new string generated from the original string
     * with some characters (can be none) deleted without changing the relative
     * order of the remaining characters.
     * 
     * For example, "ace" is a subsequence of "abcde".
     * A common subsequence of two strings is a subsequence that is common to both
     * strings.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: text1 = "abcde", text2 = "ace"
     * Output: 3
     * Explanation: The longest common subsequence is "ace" and its length is 3.
     * 
     */

    // using recursion
    // 2^m * 2^n
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

        // there is no need in initi in java ( its already 0) just for concept clearing
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

    // print the lcs
    static int lcs(String s1, String s2) {
        // code here
        int n = s1.length();
        int m = s2.length();

        int t[][] = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }
        String lcs = "";
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs += s1.charAt(i - 1);
                i--;
                j--;
            } else {
                if (t[i - 1][j] > t[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        System.out.print(lcs); // reverse it
        return t[n][m];
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
