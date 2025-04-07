package SIGMA.DP;

import java.util.Arrays;

public class HouseRobber {
    public int helper(int nums[], int n, int memo[]) {
        if (n <= 0)
            return 0;
        if (memo[n] != -1) {
            return memo[n];
        }
        int val1 = nums[n - 1] + helper(nums, n - 2, memo);
        int val2 = helper(nums, n - 1, memo);
        return memo[n] = Math.max(val1, val2);
    }

    public int rob(int nums[]) {
        int n = nums.length;
        int memo[] = new int[n];
        Arrays.fill(memo, -1);
        int res = helper(nums, n, memo);
        return res;
    }
    public static void main(String[] args) {
        
    }
}
