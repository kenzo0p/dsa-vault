package SIGMA.DP;

public class MaximumProfitInJobScheduling {

    private int n;

    // find the first job jiska startTing point >= currentJob ka end pointf
    private int getNextIndex(int[][] arr, int l, int currentJobEnd) {
        int r = n - 1;
        int result = n + 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid][0] >= currentJobEnd) { // we can take this task
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return result;
    }

    private int solve(int[][] arr, int i, int t[]) {
        if (i >= n) {
            return 0;
        }
        if (t[i] != -1) {
            return t[i];
        }
        int next = getNextIndex(arr, i + 1, arr[i][1]);
        int taken = arr[i][2] + solve(arr, next, t);

        int not_taken = solve(arr, i + 1, t);

        return t[i] = Math.max(taken, not_taken);
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        n = startTime.length;
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }

        int[] t = new int[n + 1];
        Arrays.fill(t, -1);
        // sort kardo according to start time
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        return solve(arr, 0, t);
    }
}