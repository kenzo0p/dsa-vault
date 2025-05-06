public class LowerAndUpperBound {

    public static int lowerBound(int arr[] , int n , int x){
        int low = 0 ,high = n-1;
        int ans = n;
        while(low<=high){
            int mid = low + (high-low)/2;
            //maybe an answer
            if(arr[mid] >= x){
                ans = mid;
                //look for small index on left
                high = mid-1;
            }else {
                //low for small index on right
                low = mid+1;
            }
        }

        return ans;
    }

    public static int upperBound(int arr[] , int n , int x){
        int low = 0 , high = n-1;
        int ans = n;
        while(low <=high){
            int  mid = low+(high-low)/2;
            if(arr[mid] > x){
                ans = mid;
                high= mid-1;//because i want smaller index
            }else {
                low = mid+1;
            }

        }
        return ans;
    }


    //using lower bound
    public static int insertElementIntoArray(int arr[] , int n , int elem){
        int low = 0,high = n-1;
        int ans = n;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid] >= elem ){
                ans = mid;
                high = mid-1;
            }else {
                low  = mid+1;
            }
        }

        return ans;
    }



    public static void main(String[] args) {
        
    }
}
