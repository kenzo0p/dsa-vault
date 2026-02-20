import java.util.*;

public class MissingElementnSortedArray {
    public int missingElementnSortedArray(int nums[], int k) {
        int n = nums.length;
        Set<Integer> st = new HashSet<>(Arrays.asList(nums));
        int count = 0;
        int start = nums[0];
        while (count != k) {
            if (!st.contains(start)) {
                count++;
            }

            start++;
        }

        return start - 1;
    }

    // next approach
    public int missingElementnSortedArray(int nums[], int k) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int missingInGap = nums[i] - nums[i - 1] - 1;
            if (missingInGap >= k) {
                return nums[i] + 1;
            }

            missingInGap -= k;
        }
        return nums[n - 1] + k;
    }

    // using binary search
    public int missingElementnSortedArray(int nums[], int k) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int missing = nums[mid] - nums[0] - k;
            if (missing < k) {
                left = mid;
            } else {
                right  = mid-1;
            }
        }
        return nums[0] + k + left;
    }

    public static void main(String[] args) {

    }
}