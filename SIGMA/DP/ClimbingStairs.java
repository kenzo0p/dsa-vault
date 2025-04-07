package SIGMA.DP;

import java.util.Arrays;

public class ClimbingStairs {

    public static int countWays(int n, int ways[]) { // => o(n)
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (ways[n] != -1) {
            return ways[n];
        }
        ways[n] = countWays(n - 1, ways) + countWays(n - 2, ways);
        return ways[n];
    }

    //using tabulation

    public static int coutnWaysTab(int n){
         int dp[] = new int[n+1];
         dp[0] = 1;
         for(int i = 1;i<=n;i++){
            if(i==1){ //why  ? -> think  when its one i-2 => -1 its not possible it will always gives a 0 ans that dp[1] = dp[1-1] i.e => 0 
                dp[i] = dp[i-1];
            }else {

                dp[i] = dp[i-1]+ dp[i-2];
            }
         }
         return dp[n];
    }

    public static void main(String[] agrs) {
        int n = 5; // n==3 => 3 & n=4 => 5 ==> total 6 ways
        int ways[] = new int[n + 1]; // 0 0 0
        Arrays.fill(ways, -1); // -1 -1 -1
        System.out.println(coutnWaysTab(n));
    }
}
