public class JumpGame {
    private Boolean memo[];

    private boolean solveCanJump(int nums[], int n, int idx) {

        if (idx == n - 1) {
            return true;
        }
        if (idx >= n) {
            return true;
        }

        if (memo[idx] != null) {
            return memo[idx];
        }

        for (int i = 1; i <= nums[idx]; i++) {
            if (solveCanJump(nums, n, idx + i)) {
                return memo[idx] = true;
            }
        }

        return memo[idx] = false;
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        memo = new Boolean[n + 1];
        return solveCanJump(nums, n, 0);
    }

    // bottom up
    class Solution {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            boolean[] memo = new boolean[n];
            // t[i] = true : means, main i tak pahoch sakta hun
            // t[i] = false : nahi pohoch sakta i tak

            memo[0] = true;

            for (int i = 1; i < n; i++) {

                // piche tak pura check karna ki waha se t[i] tak pohoch sakte hain ya nahi
                for (int j = i - 1; j >= 0; j--) {
                    // agar t[j] true hain and wo waha se jumo leke muj tak mujse aage aa sakta hain
                    // then t[i] happy
                    if (memo[j] == true && j + nums[j] >= i) {
                        memo[i] = true;
                        break;
                    }
                }
            }

            return memo[n - 1];
        }

        // smart solution

        public boolean canJump(int[] nums) {
            int n = nums.length;
            int maxReachable = 0;// current 0 pein ho
            for (int i = 0; i < n; i++) {
                if (i > maxReachable) {
                    return false;
                }

                maxReachable = Math.max(i + nums[i], maxReachable);
            }

            return true;

        }
    }
}