package SIGMA.DP.PalindromeRealtedDpProblems;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioningI {
    // Approach-2 (Using DP + Backtracking)
    // T.C : O(2^n)
    // S.C : O(n^2)
    private void solve(String s, int i, List<String> part, List<List<String>> result, boolean t[][]) {
        if (i == s.length()) { // i was able to successfull partition the entire string
            result.add(new ArrayList<>(part));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (t[i][j] == true) {
                part.add(s.substring(i, j + 1));
                solve(s, j + 1, part, result, t);
                part.remove(part.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean t[][] = new boolean[n][n];
        // Initialize the dp table for palindrme substring
        // t[i][j] = true -> s[i..j] is a palindrome

        for (int i = 0; i < n; ++i) {
            t[i][i] = true; // substring of a single character is always positive
        }

        for (int l = 2; l <= n; ++l) {
            for (int i = 0; i < n - l + 1; ++i) {
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

        List<List<String>> result = new ArrayList<>();
        List<String> partition = new ArrayList<>();
        solve(s, 0, partition, result, t);
        return result;
    }
}
