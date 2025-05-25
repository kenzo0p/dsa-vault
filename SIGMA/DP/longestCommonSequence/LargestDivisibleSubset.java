package longestCommonSequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {

    // no need to memoize as we have so much to change
    private void solve(int idx, int prev, int nums[], List<Integer> temp, List<Integer> result) {
        if (idx >= nums.length) {
            if (temp.size() > result.size()) {
                result.clear();
                result.addAll(temp);
            }
            return;
        }
        // take option
        if (prev == -1 || nums[idx] % prev == 0) {
            temp.add(nums[idx]); // take
            solve(idx + 1, nums[idx], nums, temp, result);
            temp.removeLast(); /// not take condition we dont want anything so remove it
        }
        solve(idx + 1, prev, nums, temp, result);
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int prev = -1;
        solve(0, prev, nums, temp, result);
        return result;
    }

    // using bottom up

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int t[] = new int[n];
        Arrays.fill(t, 1);
        int prev_idx[] = new int[n];
        Arrays.fill(prev_idx, -1);
        int last_chossen_idx = 0;
        int maxL = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (t[i] < t[j] + 1) {
                        t[i] = t[j] + 1;
                        prev_idx[i] = j;
                    }
                    if (t[i] > maxL) {
                        maxL = t[i];
                        last_chossen_idx = i;
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while (last_chossen_idx != -1) {
            result.add(nums[last_chossen_idx]);
            last_chossen_idx = prev_idx[last_chossen_idx];
        }
        
        return result;
    }

}
