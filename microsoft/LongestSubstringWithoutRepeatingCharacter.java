public class LongestSubstringWithoutRepeatingCharacter {
    //leetcode 3
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0;
        int right =0;
        //Set track the unique character in substring
        HashSet<Character>set = new HashSet<>();
        int maxLength = 0;
        while(right < n){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right)); //add the in the set
                //calculate the length
                maxLength = Math.max(maxLength , right-left + 1);
                right++;
            }else {
                //if it finds duplicate then remove left and left++
                set.remove(s.charAt(left));
                left++;
                    
            }
        }

        return maxLength;

    }
}
