import java.util.HashMap;

public class MajorityElementOne {
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Set<Integer>keySet =map.keySet() ;
        for (Integer key : map.keySet()) {
            if (map.get(key) > nums.length / 2) {
                return key;
            }
        }

        return -1;
    }

    public static int majorityElementNoExtraSpace(int nums[]){ //mores voting algo
        int candidate = nums[0];
        int count = 1;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] == candidate){
                count++;
            }else {
                count--;
            }

            if(count == 0){
                candidate = nums[i];
                count = 1;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {

    }
}
