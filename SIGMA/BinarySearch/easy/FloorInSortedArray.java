package BinarySearch.easy;

public class FloorInSortedArray {
    static int findFloor(int[] nums, int x) {
        // write code here
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= x) {
                ans = mid;
                left = mid + 1;
            } else if (nums[mid] > x) {
                right = mid - 1;
            }

        }
        return ans;

    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 8, 10, 10, 12, 19 };
        System.out.println(findFloor(nums, 5));
    }
}
