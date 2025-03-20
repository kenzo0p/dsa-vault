import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class LinkedHaspMaps {
    public static void main(String[]args){
        LinkedHashMap<String , Integer> map = new LinkedHashMap<>(); //doubly linkedlist
        map.put("India" , 100);  
        map.put("Indo" , 150);  
        map.put("China" , 120);  
        map.put("USA" , 50);  




        HashMap<String , Integer> map1 = new HashMap<>();
        map1.put("India" , 100);  
        map1.put("Indo" , 150);  
        map1.put("China" , 120);  
        map1.put("USA" , 50);  



        TreeMap<String , Integer> map2 = new TreeMap<>();
        map2.put("India" , 100);  
        map2.put("Indo" , 150);  
        map2.put("China" , 120);  
        map2.put("USA" , 50);  

        // System.out.println(map);  //as it is same order
        // System.out.println(map1); //unordered
        // System.out.println(map2); //alphabetical order based on key 

        


    }
}
