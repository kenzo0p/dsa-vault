package BinarySearch.medium;

public class FindTheNthRootOfANumber {
    public static int func(int mid , int n , int m){
        long ans = 1;
        for(int i = 0;i<=n;i++){
            ans = ans * mid;
            if(ans > m) return 2;
        }
        if(ans == m) return 1;
        return 0;
    }
    public static int find(int n , int m){
        int low = 1;
        int high = m;
        while(low<= high){
            int mid= (low+high)/2;
            int midN = func(mid , n , m);
            if(midN == 1){
                return mid;
            }else if(midN == 0) low = mid+1;
            else high = mid-1;
        }

        return -1;
    }
}
