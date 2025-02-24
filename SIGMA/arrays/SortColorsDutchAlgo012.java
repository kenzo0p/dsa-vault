public class SortColorsDutchAlgo012 {

    public static void sortColors(int nums[]){
        int n = nums.length;
        int low = 0 , mid = 0,high = n-1;
        while(mid <=high){
            if(nums[mid]==0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++; 
            }else if(nums[mid] == 1){
                mid++;
            }else {
                int temp  = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
    public static void main(String[]args){
        int nums[] = {2,0,2,1,1,0};
        sortColors(nums);
        for(int i = 0;i<nums.length;i++){
            System.out.println(nums[i]+" ");
        }

    }
}
