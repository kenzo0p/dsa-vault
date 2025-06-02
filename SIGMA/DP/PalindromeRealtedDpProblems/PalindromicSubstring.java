package DP.PalindromeRealtedDpProblems;

import java.util.Arrays;

public class PalindromicSubstring {

    public boolean check(String s, int i, int j) {
        if (i >= j) {
            return true;
        }

        if (s.charAt(i) == s.charAt(j)) {
            return check(s, i + 1, j - 1);
        }

        return false;
    }

    public int countSubstrings(String s) {
        int n = s.length();

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) { // check all possible substrings
                if (check(s, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    private int t[][] = new int[1001][1001];

    private boolean check(String s, int i, int j) {
        if (i > j) {
            return true;
        }
        if (t[i][j] != -1) {
            return t[i][j] == 1;
        }
        if (s.charAt(i) == s.charAt(j)) {
            boolean val = check(s, i + 1, j - 1);
            if (val == true) {
                t[i][j] = 1;
            } else {
                t[i][j] = 0;
            }
            return val;
        }

        t[i][j] = 0;
        return false;
    }

    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        for (int i[] : t) {
            Arrays.fill(i, -1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (check(s, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }


    //Bottom up
    public int countSubstrings(String s) { // o(n^2)
        int n = s.length();
        boolean[][] t = new boolean[n][n];
        // STATE - t[i][j] = true : s[i:j] is a palindrome substring shere i and j are
        // inclusive indicess
        int count = 0;
        for (int L = 1; L <= n; L++) {
            for (int i = 0; i + L - 1 < n; i++) {
                int j = i + L - 1;
                if (i == j) {
                    t[i][j] = true;
                } else if (i + 1 == j) { // example -> i = 3,j = 4 then its two length substring
                    t[i][j] = (s.charAt(i) == s.charAt(j));
                } else { //vid 26 min ex -> - (i+l)- - (j-1)- -  
                    t[i][j] = (s.charAt(i) == s.charAt(j) && t[i + 1][j - 1]);
                }

                if (t[i][j] == true) {
                    count++;
                }
            }
        }

        return count;
    }

}