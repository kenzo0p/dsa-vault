public class LargestOddNumberInAString {
    public static String largestOddNumber(String num) { //input 52
        // Iterate through the string from end to start
        for (int i = num.length() - 1; i >= 0; i--) {
            // Check if the current digit is odd
            if ((num.charAt(i) - '0') % 2 != 0) {   //'5' - '0' = 5 which is odd
                // Return the substring from 0 to i (inclusive)
                return num.substring(0, i + 1);
            }
        }
        return ""; // If no odd number is found, return an empty string

    }
}
