import java.util.*;
public class Main {
    // homework for all negative numbers o(n)
    public static void kadanesAlgo(int arr[]) {
        int ms = Integer.MIN_VALUE;
        int cs = 0;

        for (int i = 0; i < arr.length; i++) {
            cs = cs + arr[i];
            if (cs < 0) {
                cs = 0;
            }
            ms = Math.max(cs, ms);
        }
        System.out.println("Our max subarray sum is : " + ms);
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
    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4 };
        System.out.println(trappedRainWater(arr));
    }
}
