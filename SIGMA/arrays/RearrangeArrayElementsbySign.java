public class RearrangeArrayElementsbySign {

    public int[] rearrangeArray(int[] nums) {
        int[] pos = new int[nums.length];
        int[] neg = new int[nums.length];
        int p = 0, n = 0;

        // fill pos and neg
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0)
                pos[p++] = nums[i];
            else
                neg[n++] = nums[i];
        }
        int po = 0, ne = 0;
        for(int i = 0;i<nums.length;i++){
            if(i%2 == 0) nums[i] = pos[po++];
            else nums[i] = neg[ne++];
        }
        return nums;
    }

    
    public static int[] rearrange(int nums[]){//optimal
        int result[] = new int[nums.length];
        int posIdx = 0;
        int negIdx = 1;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>=0){
                result[posIdx] = nums[i];
                posIdx +=2;
            }else {
                result[negIdx] = nums[i];
                negIdx += 2;
            }
        }
        return result;
    }
}
