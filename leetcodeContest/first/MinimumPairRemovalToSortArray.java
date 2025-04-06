package leetcodeContest.first;

import java.util.ArrayList;

public class MinimumPairRemovalToSortArray {

    // Constraints:
    // 1 <= nums.length <= 50
    // -1000 <= nums[i] <= 1000

    /*
     * Let’s re-analyze the problem briefly:
     * ✅ You can merge the leftmost adjacent pair with the smallest sum,
     * ✅ Your goal is to make the array non-decreasing.
     */

    /*
     * Brute approach =>
     * First store all the elem in list for making it dynamic
     * then check is array is sorted in non-decreasin order if not then find the sum
     * of the elem of pairs so that they will less than smallest and find the index
     * to where we have to put the sum of pair to array is ssorted them put smallest
     * in list and remove index + 1 from list why remove ? because we calculate the
     * sum of i and i+1 then store it in i i.e ind so we dont need i+1;
     */
    private static boolean isNonDecreasing(ArrayList<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1))
                return false;
        }
        return true;
    }

    public static int brute(int nums[]) {
        ArrayList<Integer> list = new ArrayList<>();
        int index = 0;
        int operations = 0;
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        while (!isNonDecreasing(list)) {
            int smallest = Integer.MAX_VALUE; // after ach opeartions we have to again initialize it
            for (int i = 1; i < list.size(); i++) {
                if ((list.get(i - 1) + list.get(i)) < smallest) {
                    smallest = (list.get(i - 1) + list.get(i));
                    index = i - 1;
                }
            }

            list.set(index, smallest);
            list.remove(index + 1);
            operations++;
        }
        return operations;
    }

    public static void main(String[] args) {

    }
}
