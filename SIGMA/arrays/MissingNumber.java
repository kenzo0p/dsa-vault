
// most optimal soln
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int xor1 = 0, xor2 = 0;
        for (int i = 0; i < nums.length; i++) {
            xor1 = xor1 ^ nums[i];
            xor2 = xor2 ^ (i + 1);
        }

        return (xor2 ^ xor1);
    }

    public static int missingNumber2(int nums[]) {
        int sum = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum = sum + i;
        }
        int alSum = 0;
        for (int i = 0; i < nums.length; i++) {
            alSum = alSum + nums[i];
        }
        return sum - alSum;
    }

    public static void main(String[] args) {

    }
}
