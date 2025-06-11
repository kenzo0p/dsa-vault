package You.easy;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i , j};
                }
            }
        }

        return new int[]{-1,-1};

    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer , Integer> map= new HashMap<>();
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if(map.containsKey(target - nums[i])){ // key is the number and value is index as we have to return the index
                return new int[]{i , map.get(target - nums[i])};  
            }else {
                map.put(nums[i] , i);
            }
        }

        return new int[]{-1,-1};
    }

}
