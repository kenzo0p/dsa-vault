package DP;

public class MinimumDiffPartitioningSum {
    // TODO : One question with diff name -> 1) minimum subset sum differece 2)
    // partioning subset

    // o(n*w)
    public static int mdps(int arr[]) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int w = sum / 2;
        int dp[][] = new int[n + 1][w + 1];

        // bottom up
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (arr[i - 1] <= j) { // valid

                    dp[i][j] = Math.max(arr[i - 1] + dp[i - 1][j - arr[i - 1]], dp[i - 1][j]);

                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int sum1 = dp[n][w];
        int sum2 = sum - sum1;
        return Math.abs(sum1 - sum2);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 6, 11, 5 };
        System.out.print(mdps(arr));
    }
}