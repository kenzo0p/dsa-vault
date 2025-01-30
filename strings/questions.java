import java.util.Arrays;
import java.util.Scanner;

public class questions {
    public static int vowels(String str) {
        str = str.toLowerCase();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
                    || str.charAt(i) == 'u') {
                count++;
            }
        }
        return count;
    }

    public static boolean anagram(String str, String str1) {
        str = str.toLowerCase();
        str1 = str1.toLowerCase();
        if (str1.length() == str.length()) {
            char[] strToArray = str.toCharArray();
            char[] str1ToArray = str1.toCharArray();
            Arrays.sort(strToArray);
            Arrays.sort(str1ToArray);

            boolean result = Arrays.equals(strToArray, str1ToArray);
            if (result) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the string : ");
        // String str = sc.nextLine();
        String s1 = "race";
        String s2 = "care";
        System.out.println(anagram(s1, s2));
        if (anagram(s1, s2)) {
            System.out.println("This is an anagram");
        } else {
            System.out.println("This is not anagram");
        }
    }
}
