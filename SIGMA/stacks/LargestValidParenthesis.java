import java.util.Stack;

public class LargestValidParenthesis {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                if (!st.isEmpty()) {
                    st.pop();
                    if (!st.isEmpty()) {
                        ans = Math.max(ans, i - st.peek());
                    } else {
                        ans = Math.max(ans, i - index);
                    }
                } else {
                    index = i;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
