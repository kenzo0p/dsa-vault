package BinarySearch.easy;

public class FindMinimumInRotatedSortedArray {


    //ologn and for not unique elem nlogn
    public static int find(int nums[]){
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = (low + high)/2;
            if(nums[low] <= nums[mid]){
                min  = Math.min(nums[low]  , min);
                low = mid+1;
            }else {
                min = Math.min(nums[mid] , min);
                high = mid -1;
            }

        }
        return min;
    }


    public static int find(int nums[]){
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = (low + high)/2;
            if(nums[low] <= nums[high]){
                min = Math.min(min , nums[low]);
                break;
            }
            if(nums[low] <= nums[mid]){
                min  = Math.min(nums[low]  , min);
                low = mid+1;
            }else {
                min = Math.min(nums[mid] , min);
                high = mid -1;
            }

        }
        return min;
    }
}