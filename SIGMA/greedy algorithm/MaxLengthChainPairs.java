import java.util.*;

public class MaxLengthChainPairs {
    /*
        same as activity selction exact

     * You are given n pairs of numbers . in every pair , the first number is always
     * smaller then the second number . A pair (c,d) can come after pair (a,b) if
     * b<c (a->b , c->b b<c ). find the longest chain which can be formed from a given set of pairs
     * pairs -> see the pairs[][]
     * output -> 3
     *   
     * -----------------------------
     * 0  10 20 30 40 50 60 70 80 90
     * 
     * 
     * 
     */
    public static int maxLengthChainPairs(int pairs[][]) { //o(nlogn)
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int chainLength = 1;
        int chainEnd = pairs[0][1];// last selected pair end //chain end

        for (int i = 1; i < pairs.length; i++) {
            // a->b  c -> d = c>d
            if (pairs[i][0] > chainEnd) {
                chainLength++;
                chainEnd = pairs[i][1];
            }
        }
        return chainLength;
    }

    public static void main(String[] args) {
        int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };
        int length = maxLengthChainPairs(pairs);
        System.out.println(length);
    }
}
