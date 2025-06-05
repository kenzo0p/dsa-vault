package PalindromeRealtedDpProblems;

import java.util.Arrays;

public class MinimumInsertionStepsToMakeAStringPalindrome {
    /*
     * 1312. Minimum Insertion Steps to Make a String Palindrome
     * Given a string s. In one step you can insert any character at any index of
     * the string.
     * 
     * Return the minimum number of steps to make s palindrome.
     * 
     * A Palindrome String is one that reads the same backward as well as forward.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: s = "zzazz"
     * Output: 0
     * Explanation: The string "zzazz" is already palindrome we do not need any
     * insertions.
     * Example 2:
     * 
     * Input: s = "mbadm"
     * Output: 2
     * Explanation: String can be "mbdadbm" or "mdbabdm".
     * Example 3:
     * 
     * Input: s = "leetcode"
     * Output: 5
     * Explanation: Inserting 5 characters the string becomes "leetcodocteel".
     */

    // Approach-1 (Recur + Memo - Using Straight Forward Pallindromic Property)
    // T.C : O(n*n)
    // S.C : O(n*n)
    class Solution {
        private int[][] t;

        private int solve(int i, int j, String s) {
            if (i >= j)
                return 0;

            if (t[i][j] != -1)
                return t[i][j];

            if (s.charAt(i) == s.charAt(j))
                return t[i][j] = solve(i + 1, j - 1, s);

            return t[i][j] = 1 + Math.min(solve(i, j - 1, s), solve(i + 1, j, s));
        }

        public int minInsertions(String s) {
            int n = s.length();
            t = new int[n][n];

            for (int[] row : t)
                Arrays.fill(row, -1);

            return solve(0, n - 1, s);
        }
    }

    public int minInsertions(String s) {
        int n = s.length();
        int t[][] = new int[n][n];
        // t[i][j] = minimum insertion to make s[i..j] a palindrome
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j)) { // no need to insert any character
                    t[i][j] = t[i + 1][j - 1];
                } else {
                    t[i][j] = 1 + Math.min(t[i + 1][j], t[i][j - 1]);
                }
            }
        }

        return t[0][n - 1];
    }

}
