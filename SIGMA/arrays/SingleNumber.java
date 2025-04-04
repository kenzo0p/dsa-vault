import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public static int singleNumber(int nums[]) { // extreme brute
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int cnt = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != num) {
                    cnt++;
                }
            }
            if (cnt == 1) {
                return num;
            }
        }
        return -1;

    }

    public static int getSingleElement(int[] arr) {
        // size of the array:
        int n = arr.length;

        // Find the maximum element:
        int maxi = arr[0];
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }

        // Declare hash array of size maxi+1
        // And hash the given array:
        int[] hash = new int[maxi + 1];
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }

        // Find the single element and return the answer:
        for (int i = 0; i < n; i++) {
            if (hash[arr[i]] == 1)
                return arr[i];
        }

        // This line will never execute
        // if the array contains a single element.
        return -1;
    }

    public static int getSingleElement1(int[] arr) {
        // size of the array:
        int n = arr.length;

        // Declare the hashmap.
        // And hash the given array:
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int value = mpp.getOrDefault(arr[i], 0);
            mpp.put(arr[i], value + 1);
        }

        // Find the single element and return the answer:
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() == 1) {
                return it.getKey();
            }
        }

        // This line will never execute
        // if the array contains a single element.
        return -1;
    }

    public static int getSingleElement2(int[] arr) {
        /*
         * Assume the given array is: [4,1,2,1,2]
         * XOR of all elements = 4^1^2^1^2
         * = 4 ^ (1^1) ^ (2^2)
         * = 4 ^ 0 ^ 0 = 4^0 = 4
         * Hence, 4 is the single element in the array.
         */
        // size of the array:
        int n = arr.length;

        // XOR all the elements:
        int xorr = 0;
        for (int i = 0; i < n; i++) {
            xorr = xorr ^ arr[i];
        }
        return xorr;
    }

    public static void main(String[] args) {
        int nums[] = { 4, 1, 2, 1, 2 };
        System.out.println(singleNumber(nums));
    }
}
