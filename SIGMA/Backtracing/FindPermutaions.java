public class FindPermutaions {
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
        String str = "abc";
        findPermutaions(str, "");
    }
}
