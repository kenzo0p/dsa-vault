package longestCommonSequence;

import java.util.Arrays;

public class LongestStringChain {

          int n;
    int[][] t = new int[1001][1001];

    private boolean predecessor(String prev, String curr) {
        int m = prev.length();
        int n = curr.length();
        if (m >= n || n - m != 1) {
            return false;
        }

        int i = 0, j = 0;
        while (i < m && j < n) {
            if (prev.charAt(i) == curr.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == m;
    }

    private int lis(String words[], int prevIdx, int currIdx) {
        if (currIdx == n) {
            return 0;
        }

        if (prevIdx != -1 && t[prevIdx][currIdx] != -1) {
            return t[prevIdx][currIdx];
        }
        int taken = 0;
        if (prevIdx == -1 || predecessor(words[prevIdx], words[currIdx])) {
            taken = 1 + lis(words, currIdx, currIdx + 1);
        }
        int notTaken = lis(words, prevIdx, currIdx + 1);
        if (prevIdx != -1) {
            t[prevIdx][currIdx] = Math.max(taken, notTaken);
        }
        return Math.max(taken, notTaken);
    }

    public int longestStrChain(String[] words) {
        n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                t[i][j] = -1;
            }
        }

        Arrays.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        return lis(words, -1, 0);

    }


    //using bottom up


    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        int[] t = new int[n];
        Arrays.fill(t, 1);
        int maxL = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {

                if (predecessor(words[j], words[i])) {
                    t[i] = Math.max(t[i], t[j] + 1);
                    maxL = Math.max(maxL, t[i]);
                }
            }
        }

        return maxL;
    }
        
    public boolean predecessor(String prev, String curr) {
        int M = prev.length();
        int N = curr.length();

        if (M >= N || N - M != 1)
            return false;

        int i = 0, j = 0;
        while (i < M && j < N) {
            if (prev.charAt(i) == curr.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == M;
    }
    
}
