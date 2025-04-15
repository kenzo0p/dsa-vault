package gfg_160.Arrays;
import java.util.*;
public class MajorityElemII {

    public static ArrayList<Integer> optimal(int nums[]){
        ArrayList<Integer>ans = new ArrayList<>();
        HashMap<Integer , Integer>map = new HashMap<>();
        for(int num: nums){
            map.put(num , map.getOrDefault(num, 0) + 1);
        }

        for(int key : map.keySet()){
            if(map.get(key) > nums.length/3){
                ans.add(key);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
