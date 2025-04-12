public class MaximumSumCircularSubarray {

    // brute force
    // Rotate array left by 1
    public void rotate(int[] a, int n) {
        int temp = a[0];
        for (int i = 0; i < n - 1; i++) {
            a[i] = a[i + 1];
        }
        a[n - 1] = temp;
    }

    // Kadane's algorithm
    public int kadanes(int[] a, int n) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = 0; i < n; i++) {
            currSum += a[i];
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0)
                currSum = 0;
        }

        return maxSum;
    }

    // Main function
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            rotate(nums, n);
            result = Math.max(result, kadanes(nums, n));
        }

        return result;
    }

    // optimal

    static int kadanensMax(int nums[], int n) {
        int sum = nums[0];
        int mxSum = nums[0];
        for (int i = 1; i < n; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            mxSum = Math.max(mxSum, sum);
        }
        return mxSum;
    }
    static int kadanensMin(int nums[], int n) {
        int sum = nums[0];
        int minSum = nums[0];
        for (int i = 1; i < n; i++) {
            sum = Math.min(sum + nums[i], nums[i]);
            minSum = Math.min(minSum, sum);
        }
        return minSum;
    }

    public static int optimal(int nums[]) {
        int n = nums.length;
        int sum = 0;
        // point 1
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // point 2
        int minSum = kadanensMin(nums, n);
        // point 3
        int mxSum = kadanensMax(nums, n);

        // point 4.
        int cirularSum = sum - minSum;

        if (mxSum > 0) {
            return Math.max(mxSum, cirularSum);
        }
        return mxSum;

    }

    public static void main(String[] args) {

    }
}

/*
 * rotate the array -> then kadanens algo
 * 
 */