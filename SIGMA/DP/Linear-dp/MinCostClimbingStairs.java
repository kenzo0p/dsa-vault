package DP.Linear-dp;

public class MinCostClimbingStairs {
    /*
     * 
     * 746. Min Cost Climbing Stairs
     * You are given an integer array cost where cost[i] is the cost of ith step on
     * a staircase. Once you pay the cost, you can either climb one or two steps.
     * 
     * You can either start from the step with index 0, or the step with index 1.
     * 
     * Return the minimum cost to reach the top of the floor.
     * 
     * input- > {10 , 15 , 20}
     * output -> 15
     * 
     * explination -> we have to go out of the array and we have to calculate the
     * min cost it will take to go out of bound i.e on the top floor so if we go
     * from 10 take 2 steps 10+20 => 30 or 10+15 = 25 so we cant fo
     * 
     * 
     * we need to directly choose 15 he can go two steps forward and can go out of
     * bound with 15 cost
     * 
     */


     private int t[] = new int[1001];

    private int solve(int idx, int cost[]) {
        if (idx >= cost.length) {
            return 0;
        }
        if (t[idx] != -1) {
            return t[idx];
        }

        int a = cost[idx] + solve(idx + 1, cost);
        int b = cost[idx] + solve(idx + 2, cost);
        ;

        return t[idx] = Math.min(a, b);
    }

    public int minCostClimbingStairs(int[] cost) {
        Arrays.fill(t, -1);
        int n = cost.length;
        return Math.min(solve(0, cost), solve(1, cost));
    }


      public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n==2){
            return Math.min(cost[0] , cost[1]);
        }

    for(int i = 2;i<n;i++){
        //Calculate the cost of i when getting the step 1 and 2 also we have add that step cost
            cost[i] = cost[i] + Math.min(cost[i-1] , cost[i-2]);
        }

        return Math.min(cost[n-1] , cost[n-2]);
    }

}
