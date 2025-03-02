import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplyfyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] tokens = path.split("/");

        for (String token : tokens) {
            if (token.isEmpty() || token.equals(".")) {
                continue;
            }
            if (token.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(token);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }

        return result.length() == 0 ? "/" : result.toString();
    }

    public String simplifyPath2(String path) {
        List<String> list = new ArrayList<>();
        String[] tokens = path.split("/");

        for (String token : tokens) {
            if (token.isEmpty() || token.equals(".")) {
                continue;
            }
            if (token.equals("..")) {
                if (!list.isEmpty()) {
                    list.remove(list.size() - 1);
                }
            } else {
                list.add(token);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String dir : list) {
            result.append("/").append(dir);
        }

        return result.length() == 0 ? "/" : result.toString();
    }

    public static void main(String[] args) {

    }

}
