import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class EvaluateReversepolishNotation {
    //TODO : jo evaluate express wale question hote to stack bare mein jarur sochna
private int Operate(int a , int b , String token){
        if(token.equals("+")) {
            return a + b;
        }
        else if(token.equals("-")) {
            return a - b;
        }
        else if(token.equals("/")) {
            return a / b;
        }
        else {
            return a * b;
        }
    }
    public int evalRPN(String tokens[]) {
        Stack<Integer>st = new Stack<>();
        for(String token : tokens){
            if(token.equals("+") || token.equals("-") ||token.equals("*") || token.equals("/")){
                //top two elements ko pop opearate karlo then push in stack
                    int b = st.pop();
                    int a = st.pop();
                    int result = Operate(a,b ,token);
                    st.push(result);
            }else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.peek();
    }



     public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int result = 0;

        Map<String, BiFunction<Integer, Integer, Integer>> mp = new HashMap<>();
        mp.put("+", (a, b) -> a + b);
        mp.put("-", (a, b) -> a - b);
        mp.put("*", (a, b) -> (int)((long)a * (long)b));
        mp.put("/", (a, b) -> a / b);

        for (String s : tokens) {
            if (mp.containsKey(s)) {
                int b = st.pop();
                int a = st.pop();

                result = mp.get(s).apply(a, b);
                st.push(result);
            } else {
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}
