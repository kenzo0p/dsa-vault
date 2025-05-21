package SIGMA.DP.longestCommonSequence;

import java.util.Arrays;
import java.util.HashSet;

//o(n*m)
public class LongestIincreasingSubSequence {

    /*
     * 300. Longest Increasing Subsequence
     * Medium
     * Given an integer array nums, return the length of the longest strictly
     * increasing subsequence.
     * 
     * Example 1: 
     * Input: nums = [10,9,2,5,3,7,101,18]
     * Output: 4
     * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the
     * length is 4.
     */

    // using memo

    private int n;

    private int solve(int dp[][], int nums[], int i, int prevIndex) {
        if (i >= n) {
            return 0;
        }

        if (prevIndex != -1 && dp[i][prevIndex] != -1) {
            return dp[i][prevIndex];
        }
        int take = 0;
        if (prevIndex == -1 || nums[i] > nums[prevIndex]) {
            take = 1 + solve(dp, nums, i + 1, i);
        }
        int skip = solve(dp, nums, i + 1, prevIndex);
        if (prevIndex != -1) {
            dp[i][prevIndex] = Math.max(take, skip);// it still run without return here
        }
        return Math.max(take, skip);
    }

    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        int dp[][] = new int[n + 1][n + 1];
        for (int d[] : dp) {
            Arrays.fill(d, -1);
        }
        return solve(dp, nums, 0, -1);
    }

    // using bottom up

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int t[] = new int[n];
        Arrays.fill(t, 1);
        int maxLis = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    t[i] = Math.max(t[i], t[j] + 1);
                    maxLis = Math.max(maxLis, t[i]);
                }
            }
        }

        return maxLis;
    }
    

















    

    public static int lcs(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;
        int dp[][] = new int[n + 1][m + 1];
        // inialize
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = 0;
        }
        // BOTTOM UP
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];

    }

    //another method

    public static int longestIncreasingSubSequence(int nums[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        // set.size() unique elem
        int arr[] = new int[set.size()];// sorted unique elem
        int i = 0;
        for (int num : set) {
            arr[i] = num;
            i++;
        }

        Arrays.sort(arr);
        return lcs(nums, arr);

    }

    public static void main(String[] args) {
        int arr[] = { 50, 3, 10, 7, 40, 80 };
        System.out.println(longestIncreasingSubSequence(arr));
 
    }
}
