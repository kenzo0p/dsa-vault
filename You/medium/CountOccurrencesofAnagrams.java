package You.medium;

public class CountOccurrencesofAnagrams {
    /*
     * 
     * Given a word pat and a text txt. Return the count of the occurrences of
     * anagrams of the word in the text.
     * 
     * Example 1:
     * 
     * Input: txt = "forxxorfxdofr", pat = "for"
     * Output: 3
     * Explanation: for, orf and ofr appears in the txt, hence answer is 3.
     * Example 2:
     * 
     * Input: txt = "aabaabaa", pat = "aaba"
     * Output: 4
     * Explanation: aaba is present 4 times in txt.
     * 
     */

    private boolean allZero(int[] counter) {
        for (int i : counter) {
            if (i != 0) {
                return false;
            }
        }

        return true;

    }

    int search(String pat, String txt) {
        // code here
        int n = txt.length();
        int[] counter = new int[26];

        // count the frq of each char in pattern
        for (int i = 0; i < pat.length(); i++) {
            char ch = pat.charAt(i);
            counter[ch - 'a']++;
        }

        int i = 0;
        int j = 0;
        int ans = 0;
        int k = pat.length();
        while (j < n) {
            counter[txt.charAt(j) - 'a']--;
            if (j - i + 1 == k) {
                if (allZero(counter)) {
                    ans++;
                }
                counter[txt.charAt(i) - 'a']++;
                i++;
            }
            j++;
        }

        return ans;

    }
}
