import java.util.*;

public class LongestSubarrayWithSumk {
    public static int longestSubArrayWithSumK(int nums[], int k) {
        int n = nums.length;
        int maxLen = 0;
        int sum = 0;
        Map<Integer, Integer> PreSumMpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            int rem = sum - k;
            if (PreSumMpp.containsKey(rem)) {
                int len =  i - PreSumMpp.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            if (!PreSumMpp.containsKey(sum)) {
                PreSumMpp.put(sum, i);
            }

        }
        return maxLen;
    }

    public static void main(String[] args) {
        int nums [] = {10, 5, 2, 7, 1, -10};
        int k  = 15;
        System.out.println(longestSubArrayWithSumK(nums , k));
    }
}
