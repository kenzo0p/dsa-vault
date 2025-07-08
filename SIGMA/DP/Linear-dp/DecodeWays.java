package Linear-dp;

import java.util.Arrays;


public class DecodeWays {
    private int t[] = new int[101];

    private int solve(int i, String s, int n) {
        if (t[i] != -1) {
            return t[i];
        }
        if (i == n) {
            return t[i] = 1; // one valid split done
        }

        if (s.charAt(i) == '0') {
            return t[i] = 0; // not possible to split
        }

        int result = solve(i + 1, s, n);
        if (i + 1 < n) {
            if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6')) {
                result += solve(i + 2, s, n);

            }

        }

        return t[i] = result;

    }

    public int numDecodings(String s) {
        Arrays.fill(t, -1);
        int n = s.length();
        return solve(0, s, n);

    }

    public int numDecodings(String s) {
        int n = s.length();
        int t[] = new int[n + 1];
        // t[i] => no of ways to decode string s from index i to n
        t[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                t[i] = 0;
            } else {
                t[i] = t[i + 1];
                if (i + 1 < n) {
                    if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i) <= '6')) {
                        t[i] += t[i + 2];
                    }
                }
            }
        }

        return t[0];

    }

}
