import java.util.Stack;

public class RemoveOuterMostParenthesis {
    
    public static String removeUsingStack(String s) {
        Stack<Character> bracket = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (bracket.size() > 0) {
                    sb.append(s.charAt(i));
                }

                bracket.push(s.charAt(i));
            } else {
                bracket.pop();
                if (bracket.size() > 0) {
                    sb.append(s.charAt(i));
                }
            }

        }
        return sb.toString();
    }
 

    public static String remove(String s) {
        int balance = 0; // to keep the track of balance para
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (balance > 0) {
                    result += s.charAt(i);
                }
                balance++;
            } else {
                balance--;
                if (balance > 0) { // if we still have bal >1 then we have close para for that open
                    result += s.charAt(i);
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {

    }

}

/*
 * bal 1 = 1result= () () ()
 * (()*()) (())
 * 
 * 
 * 
 * bracket =>
 * 
 */
