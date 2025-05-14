import java.util.HashMap;

public class IsomorphicString {
    public static boolean isIsomorphic(String s, String t) {
         if (s.length() != t.length()) return false;

    HashMap<Character, Character> sToT = new HashMap<>();
    HashMap<Character, Character> tToS = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
        char c1 = s.charAt(i);
        char c2 = t.charAt(i);

        // Check s to t mapping
        if (sToT.containsKey(c1)) {
            if (sToT.get(c1) != c2) return false;
        } else {
            sToT.put(c1, c2);
        }

        // Check t to s mapping
        if (tToS.containsKey(c2)) {
            if (tToS.get(c2) != c1) return false;
        } else {
            tToS.put(c2, c1);
        }
    }

    return true;
    }

    public static void main(String[]args){
        String s = "foo", t = "bar";
        System.out.println(isIsomorphic(s, t));
    }
}
/*
 * f b , o a , 
 * b f , a o ,
 */