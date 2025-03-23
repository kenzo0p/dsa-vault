import java.util.*;

public class MajorityElement {
    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        int count1 = 0;
        int maj1 = 0;

        int count2 = 0;
        int maj2 = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == maj1) {
                count1++;
            } else if (nums[i] == maj2) {
                count2++;
            } else if (count1 == 0) {
                maj1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                maj2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }

        }
        // verify
        int freq1 = 0;
        int freq2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == maj1) {
                freq1++;
            } else if (nums[i] == maj2) {
                freq2++;
            }
        }
        List<Integer> result = new ArrayList<>();
        if (freq1 > Math.floor(n / 3)) {
            result.add(maj1);
        }
        if (freq2 > Math.floor(n / 3)) {
            result.add(maj2);
        }
        return result;
    }

    // Using hashmap
    public static List<Integer> majorityElement2(int[] nums) {
        HashMap<Integer , Integer>map = new HashMap<>();
        List<Integer>ans = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            // Increment the count of the current number in the map.
            // If the number is not already in the map, initialize its count to 1.
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        
        }


        //check if the value is > n/3 if its then add in list
        for(Integer key : map.keySet()){
            if(map.get(key)  > nums.length/3){
                ans.add(key);
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        int nums[] = { 2, 2, 1, 1, 1, 2, 2 };
        ArrayList<Integer>list = new ArrayList<>(majorityElement2(nums));
        System.out.println(list);
    }
}
