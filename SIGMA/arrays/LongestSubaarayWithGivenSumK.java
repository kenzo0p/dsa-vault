import java.util.*;

public class LongestSubaarayWithGivenSumK {

    // for lenght
    public static int subarraySum(int[] a, int k) {
          int n = a.length; // size of the array.

        Map<Integer, Integer> preSumMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            //calculate the prefix sum till index i:
            sum += a[i];

            // if the sum = k, update the maxLen:
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // calculate the sum of remaining part i.e. x-k:
            int rem = sum - k;

            //Calculate the length and update maxLen:
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            //Finally, update the map checking the conditions:
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        return maxLen;
    }


    // leetcode 560
    

    public static void main(String[] args) {
        int nums [] = {10, 5, 2, 7, 1, -10};
        int k  = 15;
        System.out.println(subarraySum(nums , k));
    }
}
