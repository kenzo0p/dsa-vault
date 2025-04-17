package leetcodeContest;

public class Second {
    /*
     * You are given an integer array nums and an integer k. You can perform the
     * following operation any number of times:
     * 
     * Select an index i and replace nums[i] with nums[i] - 1.
     * Return the minimum number of operations required to make the sum of the array
     * divisible by k.©leetcode
     */
    public static int minOpearations(int nums[], int k) {
        int sum = 0;
        int o = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        while (sum % k != 0) {
            sum = sum - 1;
            o++;
        }
        return o;
    }

    public static void main(String[] args) {
        int nums[] = { 4, 1, 3, 888, 999, 1000, 9, 0 };
        int k = 100;
        System.out.print(minOpearations(nums, k));
    }
}
