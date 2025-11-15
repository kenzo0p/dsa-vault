package Neetcode250.TwoPointers;

public class ValidPalindromeII {
    class Solution {

        private boolean isPal(int i, int j, String s) {
            while (i <= j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }

        public boolean validPalindrome(String s) {
            int i = 0;
            int j = s.length() - 1;
            while (i <= j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return (isPal(i + 1, j, s) || isPal(i, j - 1, s));
                }

                i++;
                j--;
            }

            return true;
        }
    }
}
