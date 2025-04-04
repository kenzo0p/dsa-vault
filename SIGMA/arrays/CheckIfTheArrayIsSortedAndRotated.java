import java.util.Arrays;

public class CheckIfTheArrayIsSortedAndRotated {
    public static boolean check(int[] nums) {
        int n = nums.length;

        int[] sorted = new int[n];

        for (int r = 0; r < n; r++) {

            int idx = 0;
            for (int i = r; i < n; i++) {
                sorted[idx] = nums[i];
                idx++;
            }

            for (int i = 0; i < r; i++) {
                sorted[idx] = nums[i];
                idx++;
            }

            // check if sorted;
            boolean isSorted = true;
            for (int i = 0; i < n - 1; i++) {
                if (sorted[i] > sorted[i + 1]) {
                    isSorted = false;
                    break;
                }
            }

            if (isSorted) {
                return true;
            }
        }

        return false;
    }

    // brute optimal
    public static boolean check2(int[] nums) {
        int sorted[] = nums.clone();
        Arrays.sort(sorted);
        for (int r = 0; r < nums.length; r++) {
            boolean isSorted = true;
            for (int i = 0; i < nums.length; i++) {
                if (sorted[i] != nums[(i + r) % nums.length]) {
                    isSorted = false;
                    break;
                }
            }
            if (isSorted) {
                return true;
            }
        }
        return false;
    }

    public static boolean check3(int nums[]){//most optimal
        /*
         * why because in sorted and rotated array the peak comes only one when the 3,4,5,1,2 like here 5 > 1 peak comes one and after that again elements are sorted.....
         */
        int n = nums.length;
        int peak = 0;
        for(int i = 0;i<n;i++){
            if(nums[i] > nums[(i+1)%n]){
                peak++;
            }

        }
        return peak > 1 ? false : true;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 4, 5, 1, 2 };
        System.out.println(check(arr));
    }
}
