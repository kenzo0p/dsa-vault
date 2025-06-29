package You.medium;

public class SearchInRotatedSortedArray {

    //explaination -> https://leetcode.com/problems/search-in-rotated-sorted-array/solutions/6886181/simple-solution-using-binary-search-by-k-33vh/
     public static int search(int arr[], int target) {

        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(target ==arr[mid]){
                return mid;
            }else if(arr[low] <= arr[mid]){
                if(target >= arr[low] && target <= arr[mid]){
                    high = mid-1;
                }else {
                    low = mid+1;
                }
            }else {
                if(target >= arr[mid+1] && target <= arr[high]){
                    low = mid+1;
                }else {
                    high = mid-1;
                }
            }
        }

        return -1;
     }



     public static int helper(int nums[], int si, int ei, int target) {
        if(si > ei ){
            return -1;
        }
        int mid = (si + ei) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[si] <= nums[mid]) {
            if (nums[si] <= target && target <= nums[mid]) {
                return helper(nums, si, mid - 1, target);
            } else {
                return helper(nums, mid + 1, ei, target);
            }

        } else {
            if (nums[mid] <= target && target <= nums[ei]) {
                return helper(nums, mid + 1, ei, target);
            } else {
                return helper(nums, si, mid - 1, target);
            }
        }
    }

    public static int search2(int nums[], int target) {
        return helper(nums, 0, nums.length - 1, target);
    }
}
