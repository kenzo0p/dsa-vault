package Neetcode250.TwoPointers;

public class MergeStringAlternatively {
    class Solution {
        public String mergeAlternately(String word1, String word2) {
            StringBuilder result = new StringBuilder();
            int m = word1.length();
            int n = word2.length();
            int i = 0, j = 0;
            while (i < m && j < n) {
                result.append(word1.charAt(i));
                result.append(word2.charAt(j));
                i++;
                j++;
            }

            while (i < m) {
                result.append(word1.charAt(i));
                i++;
            }

            while (j < n) {
                result.append(word2.charAt(j));
                j++;
            }

            return result.toString();

        }
    }

}
