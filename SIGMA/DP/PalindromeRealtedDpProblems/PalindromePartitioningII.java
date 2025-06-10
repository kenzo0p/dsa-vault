package SIGMA.DP.PalindromeRealtedDpProblems;

import java.util.Arrays;

public class PalindromePartitioningII {
    private int t[][] = new int[2001][2001];
    //tc =>  o(n^2 * (n)) ~ o(n^3)
    //sc => o(n^2)
    private boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }
        return true;
    }

    private int solve(String s, int i, int j) {
        if (i >= j) {
            return 0; // 0 cuts
        }

        if (t[i][j] != -1) {
            return t[i][j];
        }
        if (isPalindrome(s, i, j)) { // => o(n)
            return t[i][j] = 0; // 0 cuts as its a palindrome
        }

        int cuts = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) { // =>  o(n)
            int temp = 1 + solve(s, i, k) + solve(s, k + 1, j);
            cuts = Math.min(cuts, temp);
        }
        return t[i][j] = cuts;

    }

    public int minCut(String s) {
        int n = s.length();
        //t[n+1][n+1] =>  o(n^2)
        for (int memo[] : t) {
            Arrays.fill(memo, -1);
        }
        return solve(s, 0, n - 1);
    }




     //tc => o(n^2)
     //sc => o(n^2)
    public int minCut(String s) {
        int n = s.length();
        
        //blue print code use
        boolean t[][] = new boolean[n][n];

        //diagonal elements are always true i.e one character
        //length = 1 
        for (int i = 0; i < n; i++) {
            t[i][i] = true;
        }
        //length >= 2
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (l == 2) {
                        t[i][j] = true;
                    } else {
                        t[i][j] = t[i + 1][j - 1];
                    }
                }
            }
        }

        int dp[] = new int[n];
        //dp[i] = min cuts required to cut  a string s from 0 to i  into palindrome
        for(int i = 0;i<n;i++){
            if(t[0][i] == true){//s[0..i] is a palidrome
                dp[i] = 0; // not cuts required
            }else {
                dp[i] = Integer.MAX_VALUE;
                for(int k = 0;k<i;k++){
                    if(t[k+1][i] == true && 1+dp[k] <  dp[i]){
                        dp[i] = 1+dp[k];
                    }
                }
            }
        }

        return dp[n-1]; //s[0...n-1] entire string min cuts rewired to split it into palindromes only

    }
}
