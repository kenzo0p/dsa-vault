import java.util.*;
public class IndianCoins {


    /*
     * We are given an infinite supply of denominations [1,2,5,10,20,50,100,500,2000].
     * Find min no. of coins/notes to make change for value v
     * 
     * v = 121
     * ans = 3(100+20+1)
     * 
     * v = 590
     * ans = 4(500 + 50 + 20  + 20)
     * 
     * step 1 -> Sort the coins in resverse order if we cant then we will get more numbe of coins
     * step 2 -> for loop
     * 
     * 
     * 
     * 
     * 
     * 
     */

    public static int indianCoins(Integer coins[]  , int amount){
        Arrays.sort(coins , Comparator.reverseOrder());
        int countOfCoins = 0;
        ArrayList<Integer>ans = new ArrayList<>();
        for(int i = 0;i<coins.length;i++){
            if(coins[i] <= amount){
                while(coins[i] <= amount){
                    countOfCoins++;
                    ans.add(coins[i]);
                    amount -= coins[i];
                }
            }
        }
        for(int i = 0;i<ans.size();i++){
            System.out.print(ans.get(i) +  " ");
        }
        return countOfCoins;
    }
    public static void main(String[] args) {
        Integer coins[] = {1,2,5,10,20,50,100,500,2000};
        int amount = 10000;
        int count = indianCoins(coins, amount);
        System.out.println(count);
    }
}
