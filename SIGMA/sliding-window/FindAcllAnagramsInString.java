package sliding

import java.util.List;
import java.util.ArrayList;
// https://leetcode.com/problems/find-all-anagrams-in-a-string/solutions/6894149/find-all-anagrams-in-string-sliding-wind-6eot/
public class FindAcllAnagramsInString {
    private boolean allZero(int counter[]){
        for(int idx : counter){
            if(idx!=0){
                return false;
            }
        }


        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        int n  = s.length();
        int k = p.length();

        int counter[] = new int[26]; //counter map to store p element freq\
        for(char ch : p.toCharArray()){
            counter[ch- 'a']++;
        }

        int i = 0;
        int j = 0;
        List<Integer>result = new ArrayList<>();

        while(j<n){
            counter[s.charAt(j) - 'a']--;
            if(j-i+1 == k){
                if(allZero(counter)){
                    result.add(i);
                }
                counter[s.charAt(i) - 'a']++;
                i++;
            }
        }

        return result;
    
    }
}
