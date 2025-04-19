import java.util.ArrayList;
import java.util.Stack;

public class StackCollection {
    public static void pushAtBottom(Stack<Integer> stack, int data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        int top = stack.pop();
        pushAtBottom(stack, data);
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
        // top will store the elem
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);

    }

    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static ArrayList<Integer> stockSpan(int stocks[]) {// o(n)
        // creating a new stack for comaparing the elem of that index is greater than or not
        Stack<Integer> s = new Stack<>();
        // this list is to store the answer
        ArrayList<Integer> span = new ArrayList<>();
        // for first day everytime our stacks value is 1
        span.add(1);
        // push 0 so that it can compare with next elem 
        s.push(0);

        // this loop will check and calculate the span for everyday
        for (int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];
            while (!s.isEmpty() && currPrice >= stocks[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span.add(i + 1);

            } else {
                span.add(i - s.peek());

            }
            s.push(i);
        }
        return span;
    }

    public static int[] nextGreater(int nums[]){
        Stack<Integer> stack = new Stack<>();
        int nextGreater[] = new int[nums.length];
        // backward start from 3

        for (int i = nums.length - 1; i >= 0; i--) {
            // 1 while loop
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            // if else 
            if (stack.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = nums[stack.peek()];

            }

            // 3 push in stack

            stack.push(i);
        }
        return nextGreater;
    }

    public static void main(String[] args) {
        int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
        // stockSpan(stocks);

        int arr[] = { 6, 8, 0, 1, 3 };
        
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
