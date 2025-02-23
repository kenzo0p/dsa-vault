import java.util.*;
public class Main {
    // homework for all negative numbers o(n)
    public static int kadanesAlgo(int nums[]) {
        int ms = nums[0];
        int cs = 0;
        for(int i = 0;i<nums.length;i++){
            cs = cs + nums[i];
            ms = Math.max(cs ,ms);
            if(cs < 0) {
                cs =0;
            }
        }
        return ms;
    }

    public static int trappedRainWater(int height[]) {//o(n)
        int n = height.length;
        // calcaulate left max boundry
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        // calcaulate right max boundry
        int rightMax[] = new int[n];
        rightMax[n-1] = height[n-1];
        for (int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        int trappedWater = 0;
        // loop
        for (int i = 0; i < n; i++) {

            // waterlevel = min(leftmax bound , rightmax bound)
            int waterlevel = Math.min(leftMax[i], rightMax[i]);

            // trapped water = water level
            trappedWater += waterlevel - height[i];
        }
        return trappedWater;
    }
    public static int buyAndSellStocks(int prices[]){  //o(n)
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i =0 ; i< prices.length;i++){
            if(buyPrice < prices[i]){  //profit
                int profit = prices[i] - buyPrice;//todays profit
                maxProfit = Math.max(maxProfit , profit);

            }else {
                buyPrice = prices[i];

            }
        }
        return maxProfit;
    }
    public static int search(int arr[] , int target){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        while (low<=high) {
            int mid = (low+high) / 2;
            if(arr[mid] == target){
                return mid;
            }else if (arr[low] <= arr[mid]){
                if(target >= arr[low] && target <= arr[mid]){
                    high = mid -1 ;
                }else {
                    low = mid + 1;
                }
            }else {
                if(target >= arr[mid +1] && target<=arr[high]){
                    low = mid + 1;
                }else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4 };
        System.out.println(trappedRainWater(arr));
        
     }
}
