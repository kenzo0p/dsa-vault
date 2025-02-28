import java.util.Stack;

public class DuplicateParenthesis {

    public static boolean duplicateParenthesis(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // closing
            if (ch == ')') {
                int count = 0;
                while (st.pop() != '(') {
                    count++;
                }
                if (count < 1) {
                    return true;// duplicate
                }
            } else {
                // opening
                st.push(ch);
            }

        }
        return false;
    }

    public static void main(String[] args) {
        String str = "((a+b))";
        String str2 = "(a-b)";
        System.out.println(duplicateParenthesis(str));
    }
}
