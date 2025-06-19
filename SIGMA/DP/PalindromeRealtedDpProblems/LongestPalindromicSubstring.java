package PalindromeRealtedDpProblems;

import java.util.Arrays;

public class LongestPalindromicSubstring {
    private boolean solve(int i, int j, String s) {
        if (i >= j) {
            return true;
        }

        if (s.charAt(i) == s.charAt(j)) {
            return solve(i + 1, j - 1, s);
        }

        return false;
    }

    public String longestPalindrome(String s) {
        //babad
        int n = s.length();
        int max_len = Integer.MIN_VALUE;
        int sp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (solve(i, j, s)) {
                    if (j - i + 1 > max_len) {
                        max_len = j - i + 1;
                        sp = i;
                    }
                }
            }
        }

        return s.substring(sp, sp + max_len);
    }

    int t[][] = new int[1001][1001];

    private boolean solve(int i, int j, String s) {
        if (i >= j) {
            return true;
        }

        if (t[i][j] != -1) {
            return t[i][j] == 1;
        }

        if (s.charAt(i) == s.charAt(j)) {
            boolean check = solve(i + 1, j - 1, s);
            if (check) {
                t[i][j] = 1; //true
            } else {
                t[i][j] = 0; // false
            }
            return check;
        }
        t[i][j] = 0; // otherwise false
        return false;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int max_len = Integer.MIN_VALUE;
        for (int memo[] : t) {
            Arrays.fill(memo, -1);
        }
        int sp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (solve(i, j, s)) {
                    if (j - i + 1 > max_len) {
                        max_len = j - i + 1;
                        sp = i;
                    }
                }
            }
        }

        return s.substring(sp, sp + max_len);
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean t[][] = new boolean[n][n];
        int maxL = 1;
        int idx = 0;

        // t[0][0] , t[1][1] = true diagonal elem ...........................

        for (int i = 0; i < n; i++) {
            t[i][i] = true;
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j) && l == 2) {
                    t[i][j] = true;
                    maxL = 2;
                    idx = i;
                } else if (s.charAt(i) == s.charAt(j) && t[i + 1][j - 1] == true) {
                    t[i][j] = true;
                    maxL = Math.max(maxL, j - i + 1);
                    idx = i;
                } else {
                    t[i][j] = false;
                }
            }
        }
        return s.substring(idx, idx + maxL);
    }

}
