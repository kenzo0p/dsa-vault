import java.util.*;

public class MinimumAbsDiffPairs {

    /*
     * Question -> Given two arrays A and B of equal length n. Pair each elem of
     * array A to an elem in array B ,such that sum S of absolute diff of all the
     * pairs is minimum
     * 
     * explaination that means we can subtract any elem from a array to b 
     * 
     * case 1 -> |1-2|+|2-1|+|3-3| => 2
     * case 2 -> |1-3|+|2-1|+|3-2| => 4
     * case 3 -> |1-1|+|2-2|+|3-3| => 0
     * 
     * 
     * simple logic if we sort the arrays then it will give us answers immediately like we have to arrays 123 , 123 unsorted i f we sorted them then subtract then it will give the minimum diff
     * 
     * 
     * 
     */

    public static int minimumAbsDiffPairs(int[] a, int b[]) {
        Arrays.sort(a);
        Arrays.sort(b);

        int minAbsDiff = 0;
        for (int i = 0; i < a.length; i++) {
            minAbsDiff += Math.abs(a[i] - b[i]); //abs -> | -1 | -> 1
        }
        return minAbsDiff;
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 3 };
        int b[] = { 2, 1, 3 };
        int ans = minimumAbsDiffPairs(a, b);
        System.out.println(ans);
    }
}