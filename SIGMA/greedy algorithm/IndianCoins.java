import java.util.*;
public class IndianCoins {

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
