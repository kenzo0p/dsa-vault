import java.util.*;

public class FindPermutaions {
    public static void permut(String ip, String op, ArrayList<String> li) {

        if (ip.length() == 0) {
            li.add(op);
            return;
        }

        for (int i = 0; i < ip.length(); i++) {

            String newip = ip.substring(0, i) + ip.substring(i + 1);
            String newop = op + ip.charAt(i);

            permut(newip, newop, li);
        }

    }

    public static ArrayList<String> findpermute(String s) {

        ArrayList<String> li = new ArrayList<>();

        String op = "";

        permut(s, op, li);

        return li;
    }

    public static void findPermutaions(String str, String ans) {
        // base case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        // recursion
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            // "abcde" => "ab" + "de" = "abde"
            String newStr = str.substring(0, i) + str.substring(i + 1);
            findPermutaions(newStr, ans + current);
        }
    }

    public static void main(String[] args) {
        String s = "abc";

        ArrayList<String> permutations = findpermute(s);

        for (String p : permutations) {
            System.out.println(p);
        }
        String str = "abc";
        findPermutaions(str, "");
    }
}
