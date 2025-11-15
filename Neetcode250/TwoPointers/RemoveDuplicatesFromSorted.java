package Neetcode250.TwoPointers;

public class RemoveDuplicatesFromSorted {
     public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j = 0;j<=nums.length-2;j++){
            if(nums[j] != nums[j+1]){
                nums[i] = nums[j];
                i++;
            }
        }

        nums[i] = nums[nums.length-1];
        return i+1;
    }
}
