import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                if (st.isEmpty() || (c == ')' && st.pop() != '(') || (c == '}' && st.pop() != '{') // stack should not
                                                                                                   // empty false | true
                                                                                                   // -> true
                        || (c == ']' && st.pop() != '[')) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
