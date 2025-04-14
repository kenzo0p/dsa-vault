package DP.knapsack;

public class PartitionEqualSubsetSum {
    private boolean rec(int idx, int target, int nums[]) {
        if (target == 0)
            return true;
        if (idx < 0)
            return false;
        boolean yes = rec(idx - 1, target - nums[idx], nums);
        boolean no = rec(idx - 1, target, nums);
        return yes || no;
    }

    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int el : nums)
            total += el;
        if (total % 2 == 1) {
            return false;
        }
        return rec(nums.length - 1, total / 2, nums);
    }


    //usign memo
    //o(n*m) space -> o(n*t)
    private boolean rec(int idx , int target , int nums[]  , Boolean dp[][]){
        if(target == 0) return true;
        if(idx < 0) return false;
        if(dp[idx][target] != null) return dp[idx][target];
        boolean yes = (nums[idx] > target) ? false : rec(idx-1 , target - nums[idx] , nums , dp);
        boolean no = rec(idx - 1 ,target , nums ,dp);
        return dp[idx][target] = ( yes || no);
    }
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int el : nums) total += el;
        if(total%2 == 1){
            return false;
        }
        Boolean [][]dp = new Boolean[nums.length][total/2+1];
        return rec(nums.length-1 ,total/2 , nums , dp );
    
    }
}
