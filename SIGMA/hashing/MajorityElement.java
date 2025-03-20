import java.util.*;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            }
        }
        return candidate;
    }

    // Using hashmap
    public static int majorityElementSol2(int[] nums) { // o(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Set<Integer>keySet =map.keySet() ;
        for (Integer key : map.keySet()) {
            if (map.get(key) > nums.length / 3) {
                return key;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int nums[] = { 2,2,1,1,1,2,2 };
        int num = majorityElement(nums);
        System.out.println(num);
    }
}
