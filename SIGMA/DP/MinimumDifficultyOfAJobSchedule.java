import java.util.Arrays;

public class MinimumDifficultyOfAJobSchedule {
    private int solve(int jd[], int n, int idx, int d, int t[][]) {
        // base case
        // if there is only 1 day left then you have to do all remainig jobs in that one
        // day and find the max difficulty of that day and return it
        if (d == 1) {
            int maxD = Integer.MIN_VALUE;
            for (int i = idx; i < n; i++) {
                maxD = Math.max(maxD, jd[i]);
            }

            return maxD;
        }

        if (t[idx][d] != -1) {
            return t[idx][d];
        }

        int maxD = jd[idx];
        int finalResult = Integer.MAX_VALUE;
        /*
         * try one by one with all possiibility
         * take index = idx wala job in first day
         * take index = (idx , idx+1 , idx+2) wala job in first day and
         * 
         * ...so..on...
         * the find the optimal one among all the result
         */

        for (int i = idx; i <= n - d; i++) {
            maxD = Math.max(maxD, jd[i]);

            int result = maxD + solve(jd, n, i + 1, d - 1, t);
            finalResult = Math.min(finalResult, result);
        }

        return t[idx][d] = finalResult;
    }

    public int minDifficulty(int[] jd, int d) {
        int n = jd.length;
        if (d > n) {
            return -1;
        }
        int t[][] = new int[n + 1][d + 1];
        for (int memo[] : t) {
            Arrays.fill(memo, -1);
        }
        return solve(jd, n, 0, d, t);

    }

}
