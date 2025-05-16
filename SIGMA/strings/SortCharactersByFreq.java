import java.util.HashMap;
import java.util.PriorityQueue;

public class SortCharactersByFreq {
    //Google  , Zoho , oracle
    public static String sort(String s){
        HashMap<Character  , Integer> map = new HashMap<>();
        //count the freq of each char
        for(char c : s.toCharArray()){
            map.put(c , map.getOrDefault(c , 0)+1);
        }

        //create a max heap based on freq
        //if char has a higher count it comes first
        PriorityQueue<Character>pq = new PriorityQueue<>((a , b) -> map.get(b) - map.get(a));

        //add all the keys of the map
        pq.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            char current = pq.poll();
            int freq = map.get(current);
            //How many times the freq is
            for(int i = 0;i<freq;i++){
                sb.append(current);
            }
        }

        return sb.toString();
    }   
    
    public static void main(String[]args){

    }
}
