import java.util.*;

public class FractionalKnapsack {

    // greedy base algo

    /*
     * questioin -> Given two arrays, val[] and wt[], representing the values and
     * weights of items, and an integer capacity representing the maximum weight a
     * knapsack can hold, determine the maximum total value that can be achieved by
     * putting items in the knapsack. You are allowed to break items into fractions
     * if necessary.
     * Return the maximum value as a double, rounded to 6 decimal places.
     * 
     * 
     * Input: val[] = [60, 100, 120], wt[] = [10, 20, 30], capacity = 50
     * Output: 240.000000
     * 
     */
    public static int fractionalKnapsack(int val[], int weight[], int w) {
        double ratio[][] = new double[val.length][2];
        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) weight[i]; //put the ration in send col 
        }
        
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        /*
        * | 2  | 4  | 
        * | 1  | 5 | 
        * | 0 | 6  | 
        */ 

        // ascending order sorting
        int capacity = w;
        int finalVal = 0;
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0]; //find the index
            if (capacity >= weight[idx]) {// include full item
                finalVal += val[idx];
                capacity -= weight[idx];
            } else {
                // include fraction item
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        return finalVal;
    }

    public static void main(String[] args) {
        int val[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int w = 50;
        int value = fractionalKnapsack(val, weight, w);
        System.out.println(value + " ");

    }
}
