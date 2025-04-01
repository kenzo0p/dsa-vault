import java.util.*;
public class DayOne {
    public static int secondLargestElem (int nums[]){
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = n-2;i >= 0;i--){
            if(nums[i] != nums[n-1]){
                return nums[i];
            }
        }
        return -1;
    }
    public static void main(String[]args){
        int nums[] = {1,2,3,4,5,6};
        System.out.println(secondLargestElem(nums));
    }    
}
