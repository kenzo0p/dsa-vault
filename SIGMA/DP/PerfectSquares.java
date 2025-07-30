import java.util.Arrays;

public class PerfectSquares {
    private int helper(int n, int t[]) {
        if (n == 0) {
            return 0;
        }
        if (t[n] != -1) {
            return t[n];
        }
        int minCount = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int result = 1 + helper((n - (i * i)), t);
            minCount = Math.min(minCount, result);
        }

        return t[n] = minCount;
    }

    public int numSquares(int n) {
        int t[] = new int[n + 1];
        Arrays.fill(t, -1);

        return helper(n, t);
    }

    public static void main(String[] args) {

    }
}