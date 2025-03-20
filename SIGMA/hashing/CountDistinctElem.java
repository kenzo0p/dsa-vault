import java.util.*;
public class CountDistinctElem {
    //leetCode ->  1207 similar question


    public static int countDiElem(int nums[]){

        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            set.add(nums[i]);
        }
        return set.size();
        
    }
    public static void main(String[]args){
    }
}
