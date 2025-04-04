public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int nums[]){
        int j = 0;
   
        for(int i = 1;i<nums.length;i++ ){
            if(nums[j] != nums[i]){
                j++; // j= 0 then 1 j++ not ++j
                nums[j] = nums[i];
            }
        }
        return j+1;
    }
    public static void main(String[]args){
      
        
    }
}
