

public class MaximumConsequtiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxNumber = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 1){
                count++;;
                maxNumber = Math.max(maxNumber , count);
            }else {
                count = 0;
            }
        }
        return maxNumber;
    }
    public static void main(String[] args) {
        
    }
}
