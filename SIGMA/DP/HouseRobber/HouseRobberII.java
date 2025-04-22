package DP.HouseRobber;

public class HouseRobberII {
    // rec + up
    public static int solve(int i, int n, int memo[], int nums[]) {
        if (i > n) {
            return 0;
        }
        if (memo[i] != 0) {
            return memo[i];
        }
        int take = nums[i] + solve(i + 2, n, memo, nums);
        int skip = solve(i + 1, n, memo, nums);
        return memo[i] = Math.max(take, skip);
    }

    public static int rob(int nums[]) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int memo[] = new int[n];
        int ans1 = solve(1, n - 1, memo, nums);
        int ans2 = solve(0, n - 2, memo, nums);
        return Math.max(ans1, ans2);
    }

    // bottom up

    public static int bottomUp(int nums[]) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0] , nums[1]);
        }



        int memo[] = new int[n + 1];
        memo[0] = 0;
        memo[1] = nums[0];

        // case 1 -> (take 1st house - hence skip the last house)
        for (int i = 1; i <= n - 1; i++) {
            int skip = memo[i - 1];
            int take = nums[i - 1] + (i - 2 >= 0 ? memo[i - 2] : 0); // out of bound condition
            memo[i] = Math.max(skip , take);
        }
        int result1 = memo[n - 1];
        
        
        memo = new int[n + 1]; // clear for case 2
        // case 1 -> (skip 1st house - hence you can take the last house)
        memo[0] = 0;
        memo[1] = 0; //skip 1st house
        for (int i = 2; i <= n; i++) {
            int skip = memo[i - 1];
            int take = nums[i - 1] + (i - 2 >= 0 ? memo[i - 2] : 0); // out of bound condition
            memo[i] = Math.max(skip , take);
        }
        int result2 = memo[n];
        return Math.max(result1 , result2);

    }






    //without extra space
    //how to we figure how to convert into constant space
    
    private int solve(int nums[] , int l , int r){
        int prev = 0;
        int prevPrev = 0;
        for(int i = l;i<=r;i++){
            int skip = prev;
            int take = nums[i] + prevPrev;
            int temp = Math.max(skip , take);
            prevPrev = prev;
            prev = temp;
        }
        return prev;
    }

    public int robWithoutExtraSpace(int nums[]) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int take_first_house = solve(nums, 0, n - 2);
        int skip_first_house = solve(nums, 1, n - 1);
        return Math.max(take_first_house, skip_first_house);
    }

    public static void main(String[] args) {

    }
}
