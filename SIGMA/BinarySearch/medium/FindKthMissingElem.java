package BinarySearch.medium;

public class FindKthMissingElem {
    /*
     * 1539. Kth Missing Positive Number
     * Given an array arr of positive integers sorted in a strictly increasing
     * order, and an integer k.
     * 
     * Return the kth positive integer that is missing from this array.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: arr = [2,3,4,7,11], k = 5
     * Output: 9
     * Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The
     * 5th missing positive integer is 9.
     * Example 2:
     * 
     * Input: arr = [1,2,3,4], k = 2
     * Output: 6
     * Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing
     * positive integer is 6.
     */

    public static int find(int arr[], int k) { //o(n+k)
        int missingNumber = 0;
        int curr = 1;
        int index = 0;
        while (true) {
            if (index < arr.length && arr[index] == curr) {
                index++;
            } else {
                missingNumber++;
                if (missingNumber == k) {
                    return curr;
                }
            }
            curr++;
        }
    }

    //using binary search
    public static int find2(int arr[] , int k){
        int n = arr.length;
        int low = 0 , high = n-1;
        while(low<=high){
            int mid = (low + high)/2;
            int missing = arr[mid] - (mid+1);
            if(missing  < k){
                low = mid+1;
            }else {
                high =mid-1;
            }
        }
        // return high +1 +k;
        return low + k;
    }


    public static void main(String[] args) {

    }

}
