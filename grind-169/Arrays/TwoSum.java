import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int nums[], int target) {
        /*
         * How to tacke this question the brute force is nested loop
         * 
         * optimal ->
         * Optimal solution involves HashMap
         * Step -> 1 take a hashMap of integer integer
         * step -> 2 run a loop i = 0 to n
         * step -> 3 check whether the target - nums[i] is already is in hashmap if yes
         * then return otherwise put this in hashmap
         * if we dont find then return empty arrat
         */

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { i, map.get(nums[i]) };
            } else {
                map.put(nums[i], i);
            }

        }
        return new int[] {};
    }

    public static void main(String[] args) {
        
    }

}
