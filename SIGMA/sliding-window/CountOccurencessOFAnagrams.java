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
            //bhai dekh wo character ayega to minus to karna padega freq se, hain na
            counter[txt.charAt(j) - 'a']--;
            //check is this correct size of window
            if (j - i + 1 == k) { //only valid for k length
                if (allZero(counter)) { 
                    //if all are zero that means we have all elements in our window
                    ans++;
                }
                //i wale character ko minus karde
                counter[txt.charAt(i) - 'a']++;
                //aur i++
                i++; //change the window
            }

            //j to har baar badega
            j++;
        }

        return ans;

    }
}