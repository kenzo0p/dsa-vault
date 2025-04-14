package SIGMA.DP;

import java.util.Arrays;


//TODO : house robber I   , house robber II , house robber III
public class HouseRobber {
    private static int solve(int nums[], int i, int n) {
        if (i >= n)
            return 0;
        int steal = nums[i] + solve(nums, i + 2, n);
        int skip = solve(nums, i + 1, n);

        return Math.max(steal, skip);
    }

    public static int recRob(int nums[]) {
        int n = nums.length;
        return solve(nums, 0, n);
    }

    public int helper(int nums[], int n, int memo[]) {
        if (n <= 0)
            return 0;
        if (memo[n] != -1) {
            return memo[n];
        }
        int steal = nums[n - 1] + helper(nums, n - 2, memo);
        int skip = helper(nums, n - 1, memo);
        return memo[n] = Math.max(steal, skip);
    }

    public int rob(int nums[]) {
        int n = nums.length;
        int memo[] = new int[101];
        Arrays.fill(memo, -1);
        int res = helper(nums, n, memo);
        return res;
    }

    // bottom up tabu (28min code story)
    //nums = [1,2,3,1]
    public static int robTab(int nums[]) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int t[] = new int[n + 1];
        t[0] = 0;
        t[1] = nums[0];

        for (int i = 2; i < nums.length + 1; i++) {
            int steal = nums[i - 1] + t[i - 2];
            int skip = t[i - 1];
            t[i] = Math.max(steal, skip);
        }
        return t[n];
    }

    public static void main(String[] args) {

    }
}
