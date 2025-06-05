package lcs;

import java.util.Arrays;

public class LongestPalindromicSubsequence {

    /*
     * 516. Longest Palindromic Subsequence
     * Given a string s, find the longest palindromic subsequence's length in s.
     * 
     * A subsequence is a sequence that can be derived from another sequence by
     * deleting some or no elements without changing the order of the remaining
     * elements.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: s = "bbbab"
     * Output: 4
     * Explanation: One possible longest palindromic subsequence is "bbbb".
     * Example 2:
     * 
     * Input: s = "cbbd"
     * Output: 2
     * Explanation: One possible longest palindromic subsequence is "bb".
     */

    private int t[][] = new int[1001][1001];

    private int lps(String s, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }

        if (t[i][j] != -1) {
            return t[i][j];
        }

        if (s.charAt(i) == s.charAt(j)) {
            return t[i][j] = 2 + lps(s, i + 1, j - 1);
        }
        return t[i][j] = Math.max(lps(s, i + 1, j), lps(s, i, j - 1));
    }

    public int longestPalindromeSubseq(String s) {
        for (int memo[] : t) {
            Arrays.fill(memo, -1);
        }

        int m = s.length();
        return lps(s, 0, m - 1);
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int t[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            t[i][i] = 1;
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    t[i][j] = 2 + t[i + 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i][j - 1], t[i + 1][j]);
                }
            }
        }

        return t[0][n - 1];// lps of whole string
    }
}