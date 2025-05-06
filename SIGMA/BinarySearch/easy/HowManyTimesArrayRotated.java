package BinarySearch.easy;

public class HowManyTimesArrayRotated {
    public static int times(int nums[]) {
        int low = 0, high = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[low] <= nums[high]) {
                if (nums[low] < ans) {
                    index = low;
                    ans = nums[low];
                }
                break;
            }
            if (nums[low] <= nums[mid]) {
                if (nums[low] < ans) {
                    index = low;
                    ans = nums[low];
                }
            } else {
                if (nums[mid] < ans) {
                    index = mid;
                    ans = nums[mid];
                }
            }

        }

        return index;
    }

    public static void main(String[] args) {

    }
}
