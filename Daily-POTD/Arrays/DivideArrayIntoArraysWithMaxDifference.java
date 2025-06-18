package Daily-POTD.Arrays;

public class DivideArrayIntoArraysWithMaxDifference {

    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int[][] result = new int[n/3][3];
        int index = 0;
        for(int i = 0;i<n;i+=3){
            //i, i+1 , i+2
            if(nums[i+2] - nums[i] > k){
                return new int[0][0];
            }

            result[index++] = new int[]{nums[i] , nums[i+1] , nums[i+2]};

        }

        return result;

    }
    
}
