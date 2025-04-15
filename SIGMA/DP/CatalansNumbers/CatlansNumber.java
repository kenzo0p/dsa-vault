package DP.CatalansNumbers;

public class CatlansNumber { 
    //TODO: Everything is imp in dp
    public static int catlanRecursion(int n, int dp[]){
        if(n==0 || n==1){
            return 1;
        }

        if(dp[n]!=0){
            return dp[n];
        }
        for(int i =0;i<=n-1;i++){
            dp[n] += catlanRecursion(i,dp) * catlanRecursion(n-i-1,dp);
        }
        return dp[n];
    }





    //using tabulation
    public static int tab(int n){
        if(n==0|| n==1){
            return 1;
        }
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i<=n;i++){
           for(int j = 0;j<i;j++){
            dp[i] += dp[j] * dp[i-j-1];
           }
        }
        return dp[n];
    }
    public static void main(String[]args){
        int n = 4;
        int dp[] = new int[n+1];
        System.out.println(tab(n));
        
    }
}
