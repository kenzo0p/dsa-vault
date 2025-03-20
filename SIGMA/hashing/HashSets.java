import java.util.*;
public class HashSets {
    public static void  main(String[]args){
        // HashSet<Integer>set = new HashSet<>(); // unordered

        // LinkedHashSet<Integer>set = new LinkedHashSet<>();//they are just ordered not sorted
        TreeSet<Integer>set = new TreeSet<>();//sorted   null value are not allowed   o(logn) becuse of sorting
        set.add(1);
        set.add(2);
        set.add(9);
        set.add(4);
       
        // System.out.println(set);
        // set.remove(2);
        // if(set.contains(2)){
        //     System.out.println("Yes");
        // }else {
        //     System.out.println("No");
        // }

        // Iterator it = set.iterator();
        // while(it.hasNext()){
        //     System.out.println(it.next());
        // }
        for(Integer num : set){
            System.out.println(num);
        }
    }
}