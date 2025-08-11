package DP.knapsack;

import java.util.Arrays;
import java.util.HashMap;

public class TargetSum {


    //explaination -> https://leetcode.com/problems/target-sum/solutions/6882557/find-target-sum-recursive-approach-by-ke-868f/
    private int solve(int i , int curr ,int target , int nums[] ){
        if( i == nums.length){
            if(curr == target){
                return 1;
            }
            
            return 0;
        }


        
        int plus = solve(i+1 , curr + nums[i] , target ,nums  ); 
        int minus = solve(i+1 , curr - nums[i] , target ,nums ); 
        
        return plus + minus;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return solve(0 , 0 , target , nums );
    }
    
    
    //USING REC  + memo
    private int solve(int i , int curr ,int target , int nums[] , HashMap<String , Integer>memo){
        if( i == nums.length){
            if(curr == target){
                return 1;
            }
            
            return 0;
        }


        //create uniqeue key for the current state 
        String key = i + "," + curr;
        
        
        //check if result is already computed
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        int plus = solve(i+1 , curr + nums[i] , target ,nums , memo ); 
        int minus = solve(i+1 , curr - nums[i] , target ,nums , memo ); 

        memo.put(key , plus + minus);
        return memo.get(key);
    }
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String , Integer> memo = new HashMap<>();
        return solve(0 , 0 , target , nums , memo);
    }

    private int s;
    private int solve(int i , int curr ,int target , int nums[] ,int t[][]){
        if( i == nums.length){
            if(curr == target){
                return 1;
            }
            
            return 0;
        }

        //check if result is already computed
        if(t[i][curr + s] != -1){ // +s in evry where because we are doing - also so currSum will be - so add the sum in it as we want only ways not the sum
            return t[i][curr  +s];
        }
        int plus = solve(i+1 , curr + nums[i] , target ,nums , t ); 
        int minus = solve(i+1 , curr - nums[i] , target ,nums , t ); 

        
        return t[i][curr + s] = plus+minus;
    }
    public int findTargetSumWays(int[] nums, int target) {
        s = Arrays.stream(nums).sum(); //total sum stored in s
        int n = nums.length;
        int t[][] = new int[n+1][2*s+1];
        for(int m[] : t){
            Arrays.fill(m , -1);
        }
        return solve(0 , 0 , target , nums , t);
    }
    
    
    
    
    
    //using tabulation  => true false app
    public static boolean targetSumSub(int arr[] , int sum){
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];
        for(int i = 0;i<n+1;i++){
            dp[i][0] = true;
        }
        for(int i = 1;i<n+1;i++){
            for(int j = 1;j<sum+1;j++){
                int v = arr[i-1];
                //include
                if(v<=j && dp[i-1][j-v] == true){
                    dp[i][j] = true;
                }
                //exclude
                else if(dp[i-1][j] == true){
                    dp[i][j] = true;
                }
            }
        }
        
        return dp[n][sum];
    }
    
    public static void main(String[]args){
        int arr[] = {4,2,7,1,3};
        int sum = 10;
        System.out.println(targetSumSub(arr, sum));
    }
}
