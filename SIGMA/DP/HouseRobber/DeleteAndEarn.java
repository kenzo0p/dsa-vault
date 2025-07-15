package SIGMA.DP.HouseRobber;
import java.util.*;

🧩 Delete and Earn
Pick a number x.

When you pick x, you must delete all x-1 and x+1 from the array.

Your goal: maximize total points.

🧩 House Robber
You have a row of houses, each with money.

If you rob house i, you can’t rob i-1 or i+1 (adjacent).

Your goal: maximize total money.


public class DeleteAndEarn {
    private int memo[];
    private int solve(int i , int[]points){
        if(i==0) return 0;
        if(i==1) return points[1];
        if(memo[i] != -1){
            return memo[i];
        }

        int take = solve(i-2, points) + points[i];
        int skip = solve(i-1 , points);

        return memo[i] = Math.max(skip , take);
    }
    public int deleteAndEarn(int []nums){
        int max = 0;
        for(int num : nums){
            max = Math.max(num , max);
        }

        int[]points = new int[max + 1];
        for(int num : nums){
            points[num] += num;
        }
        memo = new int[max + 1];
        Arrays.fill(memo , -1);

        return solve(max , points);

    }
    //using bottom up
    public int deleteAndEarn(int[]nums){
        int n = nums.length;
        int max = 0;
        for(int num : nums){
            max = Math.max(max , num);
        }

        int points[] = new int[max+1];
        for(int num : nums){
            points[num] += num;
        }
        int t[] = new int[max + 1];

        t[0] = 0;
        t[1] = points[1];

        for(int i = 2;i<=max;i++){
            t[i] = Math.max(t[i-1] , t[i-2] + points[i]);
        }

        return t[max];

    }
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num : nums){
            max = Math.max(max , num);
        }

        int []points = new int[max+1];
        for(int num : nums){
            points[num] += num;
        }

        int take = 0;
        int skip = 0;
        for(int i = 0;i<=max;i++){
            int takei = skip + points[i];
            int skipi = Math.max(skip , take);
            take = takei;
            skip = skipi;
        }

        return Math.max(take , skip);
    }
}