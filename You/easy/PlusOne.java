public class PlusOne {
    class Solution {
        public int[] plusOne(int[] digits) {
            int n = digits.length;

            // Traverse from the end
            for (int i = n - 1; i >= 0; i--) {
                if (digits[i] < 9) {
                    digits[i]++;
                    return digits; // done, no carry
                }
                // digit was 9 -> set to 0 and carry over
                // example -> 8 , 9, 9 ,9 -> 9000
                digits[i] = 0;
            }

            // If we’re here, all digits were 9
            // e.g., [9,9,9] -> [0,0,0] -> need [1,0,0,0]
            int[] result = new int[n + 1];
            result[0] = 1;
            return result;
        }
    }

}
