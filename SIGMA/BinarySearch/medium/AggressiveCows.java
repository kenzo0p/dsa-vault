package BinarySearch.medium;

public class AggressiveCows {
    //TODO : Google asked
    private static boolean canWePlace(int stalls[] , int dist , int cows){
        int cntCows = 1 , last = stalls[0];
        for(int i = 1;i<stalls.length;i++){
            if(stalls[i] - last >= dist){
                cntCows++;
                last = stalls[i];
            }
            if(cntCows >= cows) return true;
        }
        return false;
    }
    public static int find(int stalls[] , int cows){
        int n = stalls.length;
        int low = 1;
        int high = stalls[n-1] - stalls[0];
        while(low<= high){
            int mid  = (low + high)/2;
            if(canWePlace(stalls , mid , cows) == true){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }

        return high;
    }
    
}
