package Atlassian.Easy;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    /*
     * 
     * 1. Two Sum
     * Hint
     * Given an array of integers nums and an integer target, return indices of the
     * two numbers such that they add up to target.
     * 
     * You may assume that each input would have exactly one solution, and you may
     * not use the same element twice.
     * 
     * You can return the answer in any order.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     * Example 2:
     * 
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     * Example 3:
     * 
     * Input: nums = [3,3], target = 6
     * Output: [0,1]
     */

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) { // we have to take the next element of i not before i and i
                                                        // itself
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }

        return new int[] {};
    }

    public int[] twoSumOpti(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // check agar target minus nums[i] is in map then pakka wo target ho sakta hain
            if (map.containsKey(target - nums[i])) {
                return new int[] { i, map.get(target - nums[i]) };
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[] {};
    }

    // o(nlogn)
    public int[] twoSumBinarySearch(int[] nums, int target) {
        int n = nums.length;

        // Step 1: Store number with its index
        int[][] numsWithIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            numsWithIndex[i][0] = nums[i]; // value
            numsWithIndex[i][1] = i; // index
        }

        // Step 2: Sort the array by value
        Arrays.sort(numsWithIndex, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 3: Two pointers
        int left = 0, right = n - 1;

        while (left < right) {
            int sum = numsWithIndex[left][0] + numsWithIndex[right][0];

            if (sum == target) {
                return new int[] { numsWithIndex[left][1], numsWithIndex[right][1] };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] {}; // not found
    }

}
