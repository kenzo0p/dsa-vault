import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class HaspMaps {
 






    public static void main(String[]args) {
        //creat hashmap
        //in java HashMaps are unordered
        HashMap<String , Integer>map = new HashMap<>();

        //Insert
        map.put("India" , 100);
        map.put("China" , 150);
        map.put("Us" , 50);

        // System.out.println(map);


        //get
        int population = map.get("India");
        // System.out.println(population);
        // System.out.println(map.get("Indo"));


        //contains key

        boolean hain = map.containsKey("India");
        // System.out.println(map.containsKey("Indonesia"));
        // System.out.println(hain);
        
        
        //remove operation
        
        
        // map.remove("India");
        // System.out.println(map.remove("Indonesia"));
        // System.out.println(map);


        System.out.println(map.size());
        System.out.println(map.isEmpty());
        
        
        //Iteration on maps
        //TODO:search about entrySet
        Set<String> keys = map.keySet();//our key have String data type
        // System.out.println(keys);

        for(String key : keys){
            System.out.println("keys : " + key + ", value = " +   map.get(key));
        }




        
    }
}