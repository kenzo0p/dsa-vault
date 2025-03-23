import java.util.*;

public class FindIternaryFromTickets {
    public static String getStart(HashMap<String, String> tickets) {
        //rehasp it kay value -> value key
        HashMap<String, String> revMap = new HashMap<>();
        for (String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        }
        
        for (String key : tickets.keySet()) {
            if (!revMap.containsKey(key)) {
                return key;// starting point like mumbai
            }
        }

        return null;

    }

    public static void main(String[] args) {

        /*
         * 
         * step 1) convert to hash map in this case we already converted to hashmao as key value
         * step 2) getStart elem 
         * print start everytime to get the proper path 
         */
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");
        String start = getStart(tickets);
        System.out.print(start);
        for (String key : tickets.keySet()) {
            System.out.print(" -> " + tickets.get(start));
            start = tickets.get(start);
        }
        System.out.println();
    }
}
