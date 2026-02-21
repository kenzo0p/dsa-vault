package premium.binary_search;

public class ArrangeCoins {


    /*
    
    
    hint -> its standard binary search problem 
    your just have to find how many rows we can store all the coins
    1 row -> 1 coin
    2 row -> 2 coin 
    
    so We want the maximum number of complete rows possible.
    as its 1 to n ascending order we can 

    coins we have to calulate in that row is mid *(mid+1)/2.  ex 3 -> first mid = 2 ->  coins = 2 *(2+1)/2 -> 2

    as 2 <= 3. ans = mid and low = mid+1 for checking if more is possible or not i.e try more rows

    
    
    
    
    
    
    
    */






    class Solution {
    public int arrangeCoins(int n) {
        long low = 1;
        long high = n;
        int ans = 0;
        while(low <= high){
            long mid = low + (high - low)/2;
            long coins = mid *(mid+1)/2;
            if(coins <= n){
                ans = (int)mid;
                low = mid+1;
            }else {
                high = mid-1;
            }
        }

        return ans;
    }
}
}