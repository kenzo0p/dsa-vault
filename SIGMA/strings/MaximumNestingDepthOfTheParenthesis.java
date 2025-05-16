import java.util.Stack;

public class MaximumNestingDepthOfTheParenthesis {


    /*
     * 
     * we just need parenthesis nested nothing else 
     * 
     */
    public int maxDepth(String s){
        int result = 0;
        Stack<Character>st = new Stack<>();
        for(char c  : s.toCharArray()){
            if(c == '('){
                st.push(c);
            }else if(c == ')') {
                st.pop();
            }
            Math.max(result , (int)st.size());
        }
        return result;
    }

    //using no space
        public int maxDepth(String s){
            int result = 0;
            int count = 0;
            for(char c : s.toCharArray()){
                if(c == '('){
                    count++;
                }else if(c == ')'){
                    count--;
                }
                result = Math.max(result , count);
            }
            return result;

        }

    public static void main(String[]args){

    }
}
