package BinarySearch.medium;

public class FindTheSqrtOfanInteger {

    public static int find(int n){
        int low = 1;
        int high = n;
        while(low<=high){
            int mid = (low+high)/2;
            if((mid*mid) == n){
                return mid;
            }else if((mid*mid) > n) {
                high = mid-1;
            }else {
                low = mid+1;
            }
        }

        return -1;
    }
    public static void main(String[]args){
        int n = 30;
        System.out.println(find(n));
    }
    
}
