import java.util.*;

public class QueueCollections {
    public static void main(String[]args){
        // Queue<Integer> q = new LinkedList<>();//try using array Dqueue
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
