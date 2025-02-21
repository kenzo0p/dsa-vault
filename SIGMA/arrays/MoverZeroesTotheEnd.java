import java.util.ArrayList;

public class MoverZeroesTotheEnd {

    public static void moveZeroes(int[] nums) {
        // create temp list for non zero numbers
        ArrayList<Integer> list = new ArrayList<>();

        // add the non zero numbers in list
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                list.add(nums[i]);
            }
        }

        // put them to the front of arr
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        // put zeros tothe end
        for (int i = list.size(); i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void moveZeroesOptimal(int[] nums) {
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
    }

    public static int[] m(int nums[]){
        int j = -1;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0){
                j=i;
                break;
            }
        }

        // no non zero numbers
        if(j == -1){
            return nums;
        }

        for(int i = j+1;i<nums.length;i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int arr[] = {1,3,0,5,6,0 , 7};
        m(arr);
        for(int i = 0;i<arr.length;i++){
            System.out.println(arr[i] +  " ");
        }
    }
}
