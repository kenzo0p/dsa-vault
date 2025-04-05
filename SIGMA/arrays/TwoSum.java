import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) { // brute force
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }

    public static int[] twoSumOptimal(int nums[], int target) { //optimal with extra space
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { i, map.get(target - nums[i]) };
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] {};
    }
    public static int[] twoSumNoExtraSpace(int[] nums, int target) { //o(nlogn) but still have extra spave because it have array as input type   -> not optimal as hashMap methoa -> o(n)
        int n = nums.length;

        // Step 1: Store number with its index
        int[][] numsWithIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            numsWithIndex[i][0] = nums[i]; // value
            numsWithIndex[i][1] = i;       // index
        }

        // Step 2: Sort the array by value
        Arrays.sort(numsWithIndex, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 3: Two pointers
        int left = 0, right = n - 1;

        while (left < right) {
            int sum = numsWithIndex[left][0] + numsWithIndex[right][0];

            if (sum == target) {
                return new int[] { numsWithIndex[left][1], numsWithIndex[right][1] };//on 1 there are index
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] {}; // not found
    }

    public static void main(String[] args) {
        int nums[] = { 35, 3, 2, 1, 4, 5, 6, 7 };
        int target = 42;
        System.out.println(Arrays.toString(twoSumNoExtraSpace(nums, target)));
    }
}
