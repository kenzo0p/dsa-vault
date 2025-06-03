public class CountOccurencessOFAnagrams {
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