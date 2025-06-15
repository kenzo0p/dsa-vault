import java.util.Arrays;

public class MinimizeMaximumPairSum {
         public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int j = n-1;
        int result = 0;
        while(i<j){
            int sum = nums[i] + nums[j];
            result = Math.max(result , sum);
            i++;
            j--;
        }


        return result;
    }
}
