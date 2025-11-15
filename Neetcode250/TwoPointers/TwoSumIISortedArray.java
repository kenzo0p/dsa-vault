package Neetcode250.TwoPointers;

public class TwoSumIISortedArray {
    public int[] find(int nums[], int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int fix = target - nums[i];
            int left = i + 1;
            int right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == fix) {
                    return new int[] { i + 1, mid + 1 };
                } else if (nums[mid] > fix) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return new int[] {};
    }
}
