import java.util.Stack;

public class StackCollection {
    public static void pushAtBotton(Stack<Integer> stack, int data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        int top = stack.pop();
        pushAtBotton(stack, data);
        stack.push(top);
    }

    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder("");
        while (!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }
        return result.toString();
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBotton(s, top);

    }

    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for (int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];
            while (!s.isEmpty() && currPrice > stocks[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;

            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;

            }
            s.push(i);
        }
    }

    public static void main(String[] args) {
        int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
        int span[] = new int[stocks.length];
        int arr[] = { 6, 8, 0, 1, 3 };
        Stack<Integer> stack = new Stack<>();
        int nextGreater[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            // 1 while loop
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();

            }
            // if else
            if (stack.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[stack.peek()];

            }

            // 3 push in stack

            stack.push(i);
        }

        for (int i = 0; i < nextGreater.length; i++) {
            System.out.println(nextGreater[i] + " ");
        }

        // stockSpan(stocks, span);
        // for (int i = 0; i < span.length; i++) {
        // System.out.println(span[i] + " ");
        // }

        // stack.push(1);
        // stack.push(2);
        // stack.push(3);
        // reverseStack(stack);
        // printStack(stack);
        // while(!stack.isEmpty()){
        // System.out.println(stack.pop());

        // }

        // String str = "helloworld";
        // String result = reverseString(str);
        // System.out.println(result);

    }
}
