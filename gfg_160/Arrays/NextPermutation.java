package gfg_160.Arrays;
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // Step 1: Find the breakpoint
        int ind = -1;
        for (int i = n - 2; i >= 0; i--) { // Start from n-2 to avoid out-of-bounds
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }

        // Step 2: If no breakpoint is found, reverse the array
        if (ind == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 3: Find the next greater element and swap
        for (int i = n - 1; i > ind; i--) {
            if (nums[i] > nums[ind]) {
                swap(nums, i, ind);
                break;
            }
        }

        // Step 4: Reverse the elements after the breakpoint
        reverse(nums, ind + 1, n - 1);
    }

    // Helper method to reverse a portion of the array
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    // Helper method to swap two elements in an array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

    }
}
