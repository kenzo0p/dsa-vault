package BinarySearch.medium;

public class CapacityToShipPackagesWithinDdays {

    private int findDays(int weights[], int cap){
        int days = 1 , load = 0;
        for(int i = 0;i<weights.length;i++){
            if(weights[i] + load > cap){
                days +=1;
                load = weights[i];
            }else {
                load += weights[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i = 0;i<n;i++){
            low = Math.max(weights[i] , low);
            high += weights[i];
        }
        while(low<=high){
            int mid = (low + high)/2;
            int numberOfDays = findDays(weights , mid);
            if(numberOfDays <= days){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
    return low;
    }
    public static void main(String[]args){
        
    }
    
}