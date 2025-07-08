package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs){
        HashMap<String , List<String>>map = new HashMap<>();

        for(String str : strs){
            char arr[] =str.toCharArray();
            Arrays.sort(arr);
            String currStr = new String(arr);
            if(!map.containsKey(currStr)){
                map.put(currStr , new ArrayList<>());
            }

            map.get(currStr).add(str);
        }


        return new ArrayList<>(map.values());
    }
    
}
