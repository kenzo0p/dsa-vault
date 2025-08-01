import java.util.*;
public class ArithmeticSliceIISubseq {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int result = 0;
        Map<Long , Integer>[]mp = new HashMap[n];
        for(int i = 0;i<n;i++){
            mp[i]= new HashMap<>();
            for(int j = 0;j<i;j++){
                long diff = (long) nums[i]- nums[j];
                int count_at_j = mp[j].getOrDefault(diff , 0); //count at j for difference = diff

                result += count_at_j;

                //increment the count at index 1
                mp[i].put(diff , mp[i].getOrDefault(diff , 0) + count_at_j + 1);
            }
        }


        return result;
    }
}
