import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class LongestConsequituveSeqInArray {
    private static boolean linearSearch(int nums[], int tar) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == tar) {
                return true;
            }
        }
        return false;
    }

    public static int bruteForce(int nums[]) { // o(n^2)
        int n = nums.length;
        int longest = 1;
        // pick the elem and search for its consecutive numbers
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int cnt = 1;
            // search for consecutive numbers
            // using linear search
            while (linearSearch(nums, x + 1) == true) {
                x += 1; // 1,2,3,4 like that it will find in linear search
                cnt += 1;
            }

            longest = Math.max(longest, cnt);
        }
        return longest;
    }

    public static int better(int nums[]) {
        if (nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int longest = 1;
        int count = 0;
        int lastSmaller = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 == lastSmaller) {
                count++;
                lastSmaller = nums[i];
            } else if (nums[i] != lastSmaller) {
                count = 1;
                lastSmaller = nums[i];
            }
            longest = Math.max(longest, count);
        }
        return longest;

    }

    public static int optimal(int nums[]) { //o(2n + n) => o(3n) => o(n) 
        if (nums.length == 0)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        int longest = 1;
        // put all the array elements into set
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        // Find the longest sequence
        for (int num : set) {
            // if 'num' is a starting number
            if (!set.contains(num - 1)) {
                // find consecutive numbers
                int count = 1;
                int x = num;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    count = count + 1;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;

    }

    public static void main(String[] args) {
        int[] a = { 100, 200, 1, 2, 3, 4 };
        int ans = optimal(a);
        System.out.println("The longest consecutive sequence is " + ans);

    }
}
