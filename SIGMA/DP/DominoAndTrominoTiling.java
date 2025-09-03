import java.util.Arrays;

public class DominoAndTrominoTiling {

    // TODO : Google Do it again leetcode 790

    // using rec and memo

    private int t[];
    private final int M = 1_000_000_007;

    private int solve(int n) {
        if (n == 1 || n == 2) { 
            return n;
        }
        if (t[n] != -1) {
            return t[n];
        }
        if (n == 3) {
            return 5;
        }
        return t[n] = (2 * solve(n - 1) % M + solve(n - 3) % M) % M;

    }

    public int numTilings(int n) {
        t = new int[n + 1];
        Arrays.fill(t, -1);
        return solve(n);
    }


    //using bootom up



    private final int M = 1_000_000_007;

    public int numTilings(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int t[] = new int[n + 1];
        t[1] = 1;
        t[2] = 2;
        t[3] = 5;

        for (int i = 4; i <= n; i++) {
            t[i] = (2 * t[i - 1] % M + t[i - 3] % M) % M;
        }
        return t[n];
    }

    public static void main(String[] args) {

    }
}
