package BinarySearch.medium;

public class FindTheSmallestDevisor {
    private  int sumByD(int nums[] , int div){
        int sum = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            sum = sum + (int)Math.ceil((double)(nums[i]) / (double)(div));
        }
        return sum;
    }
    public  int smallestDivisor(int nums[] , int threshold){
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            max = Math.max(nums[i] , max);

        }

        int low = 1,high = max;
        while(low<=high){
            int mid = (low+high)/2;
            if(sumByD(nums , mid) <= threshold){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return low;
    }
    public static void main(String[]args)P{

    }
}
