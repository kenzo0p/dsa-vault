package Daily-POTD.Arrays;

public class PartitionArraySuchThatMaximumDiffIsK {
       public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int count = 1; //first subseq
        int minVal = nums[0]; //this is a part subseq

        for(int i = 0;i<n;i++){
            if(nums[i] - minVal > k){
                count++;
                minVal = nums[i];
            }
        }



        return count;
    }


    
}
