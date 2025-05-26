import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MaximumBalancedSubseqSum {
    // using lis version using rec
    private long solve(int prev, int curr, int nums[]) {
        if (curr >= nums.length) {
            return 0; // no elem sum is 0
        }

        long take = Integer.MIN_VALUE;
        long not_take = Integer.MIN_VALUE;
        if (prev == -1 || nums[curr] - curr >= nums[prev] - prev) {
            take = nums[curr] + solve(curr, curr + 1, nums);
        }
        not_take = solve(prev, curr + 1, nums);
        return (long) Math.max(take, not_take);
    }

    public long maxBalancedSubsequenceSum(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        if (max <= 0) {
            return max;
        }
        return solve(-1, 0, nums);
    }

    // using memo

    private Map<String, Long> memo = new HashMap<>();

    public long solve(int i, int prev, int[] nums) {
        if (i >= nums.length) {
            return 0;
        }

        String key = i + "_" + prev;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        long taken = Integer.MIN_VALUE;

        if (prev == -1 || nums[i] - i >= nums[prev] - prev) {
            taken = nums[i] + solve(i + 1, i, nums);
        }

        long notTaken = solve(i + 1, prev, nums);
        long result = Math.max(taken, notTaken);
        memo.put(key, result);

        return result;
    }

    public long maxBalancedSubsequenceSum(int[] nums) {
        boolean allNegative = true;
        long maxEl = Integer.MIN_VALUE;
        memo.clear();

        for (int x : nums) {
            maxEl = Math.max(maxEl, x);
            if (x >= 0) {
                allNegative = false;
            }
        }

        if (allNegative) {
            return maxEl;
        }

        return solve(0, -1, nums);
    }

    // bottom up

    public long maxBalancedSubsequenceSum(int[] nums) {
        int n = nums.length;

        int maxEl = Arrays.stream(nums).max().getAsInt();
        if (maxEl <= 0) {
            return maxEl;
        }

        long[] t = new long[n];
        for (int i = 0; i < n; i++) {
            t[i] = nums[i]; // why nums[i] in dp beacuse we have to calculate the sum not length as original
                            // lis
        }

        long maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] - i >= nums[j] - j) {
                    t[i] = Math.max(t[i], t[j] + nums[i]);
                    maxSum = Math.max(maxSum, t[i]);
                }
            }
        }

        return maxSum > maxEl ? maxSum : maxEl;
    }

    // go on leetcode dry run 4,8,5, 8 -> 4 , 7 , 3, 5
    // Approach-3 (Using Optimal LIS - Similar to Patience Sorting) - Accepted
    // Time : O(nlogn)
    public long maxBalancedSubsequenceSum(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];

        // Step 1: Transform nums[i] -> nums[i] - i and store in arr[]
        // This transformation helps to maintain the "balanced" condition as per the
        // problem requirement.
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i] - i;
        }

        TreeMap<Integer, Long> map = new TreeMap<>(); // Stores {arr[i] -> max subsequence sum ending with arr[i]}
        long ans = Integer.MIN_VALUE;

        // Dry Run Input: nums = [4, 8, 5, 8]
        // arr = [4, 7, 3, 5] (i.e. [4-0, 8-1, 5-2, 8-3])

        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {

                // If current number is non-positive, only consider it alone
                ans = Math.max(ans, nums[i]);
            } else {
                // Start a new sum with just the current number
                long temp = nums[i];

                // Try to extend previous best sum if any key <= arr[i] exists
                if (map.floorKey(arr[i]) != null) {
                    // Add the best sum we can get before this element
                    temp += map.get(map.floorKey(arr[i]));
                }

                // Remove all future keys >= arr[i] that have a worse sum
                // (we only want to keep the best options in the TreeMap)
                while (map.ceilingKey(arr[i]) != null && map.get(map.ceilingKey(arr[i])) < temp) {
                    map.remove(map.ceilingKey(arr[i]));
                }

                // If this current sum is better than existing for arr[i], update it
                if (map.floorKey(arr[i]) == null || map.get(map.floorKey(arr[i])) < temp) {
                    map.put(arr[i], temp);
                }

                // Update global max
                ans = Math.max(ans, temp);
            }

            // === Dry Run Debug Output ===
            System.out.println("Step " + i + ": nums[i] = " + nums[i]);
            System.out.println("        arr[i] = " + arr[i]);
            System.out.println("        TreeMap = " + map);
            System.out.println("        Current max sum = " + ans);
        }

        return ans;
    }

}
