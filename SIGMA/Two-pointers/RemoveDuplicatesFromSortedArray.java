public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 1;
        while (j < n) {
            if (nums[i] != nums[j]) { // got a unique elem
                i++;
                nums[i] = nums[j];
            }

            j++;
        }

        return i + 1;
    }

    public static void main(String[] args) {

    }
}
