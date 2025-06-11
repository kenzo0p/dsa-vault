import java.util.Arrays;

public class NumberofSubsequencesThatSatisfytheGivenSumCondition {
    private int M = 1000000007;

    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        // . sort
        Arrays.sort(nums);
        int power[] = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = power[i - 1] * 2 % M;
        }
        // 2.l=0 , r=n-1
        int l = 0, r = n - 1;
        int result = 0;
        while (l <= r) {
            if (nums[l] + nums[r] <= target) {
                int diff = r - l;
                result = (result % M + power[diff]) % M;
                l++;
            } else {
                r--;
            }
        }
        return result;
    }
}
