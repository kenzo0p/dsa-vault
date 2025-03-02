import java.util.*;

// stack implementation usgin deque
public class UsingStack {
    static class Stack {
        Deque<Integer> deque = new LinkedList<>();
        public void push(int data){
            deque.addLast(null);
        }
        public int pop(){
            return deque.removeLast();
        }
        public int peek(){
            return deque.getLast();
        }
    }
     public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        
    }
}
