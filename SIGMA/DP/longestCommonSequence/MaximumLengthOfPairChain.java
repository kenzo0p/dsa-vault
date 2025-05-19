package SIGMA.DP.longestCommonSequence;

import java.util.Arrays;

public class MaximumLengthOfPairChain {
        private int n;
        private int solve(int dp[][], int nums[][], int i, int prevIndex) {
        if (i >= n) {
            return 0;
        }

        if (prevIndex != -1 && dp[i][prevIndex] != -1) {
            return dp[i][prevIndex];
        }
        int take = 0;
        if (prevIndex == -1 || nums[i][0] > nums[prevIndex][1]) {
            take = 1 + solve(dp, nums, i + 1, i);
        }
        int skip = solve(dp, nums, i + 1, prevIndex);
        if (prevIndex != -1) {
            dp[i][prevIndex] = Math.max(take, skip);// it still run without return here
        }
        return Math.max(take, skip);
    }


    public int findLongestChainMemo(int[][] nums) {
        n = nums.length;
        Arrays.sort(nums , (a,b) -> Integer.compare(a[0] , b[0]));
        int dp[][] = new int[n + 1][n + 1];
        for (int d[] : dp) {
            Arrays.fill(d, -1);
        }
        return solve(dp, nums, 0, -1);
    }


    public static int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        int t[] = new int[n+1];
        Arrays.fill(t , 1);
        int maxLen = 1;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<i;j++){
                if(pairs[j][1] < pairs[i][0]){
                    t[i]   = Math.max(t[i] , t[j]+1);
                    maxLen = Math.max(t[i] , maxLen);
                }
            }
        }

        return maxLen;

    }
}