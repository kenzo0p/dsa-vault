 
import java.util.*;
 
class Node {
    int data;
    Node next;
 
    Node(int key) {
        data = key;
        next = null;
    }
}
 
class NodeComparator implements Comparator<Node> {
    public int compare(Node k1, Node k2) {
        // if this method returns -ve value - that means k1 < k2
        // -ve means, k1 will come first. k1 has higher priority
        // if it returns +ve value - that means k1 > k2
        // +ve means, k2 has more priority
        // if it returns 0 - both the objects are equal
        if (k1.data < k2.data) {
            return -1000;
        } else if (k1.data > k2.data) {
            return 100;
        } else {
            return 0;
        }
    }
}
 
class MergeKSortedLists {
    static Node mergeKList(Node[] arr, int K) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
        Node head = new Node(-1); // Dummy Node
        Node tail = head; // tail No
 
        // We are inserting the head of all K lists
        // arr - This is an array of head of all the lists
        for (int i = 0; i < K; i++) {
            // if arr[i] == null. The list is empty
            if (arr[i] != null) {
                pq.add(arr[i]);
            }
        }
        // if all the linked lists are empty
        if (pq.isEmpty())
            return null;
 
        // Merge the linked lists
        while (!pq.isEmpty()) {
            // Pick the minimum Node
            Node curr = pq.poll();
            // Add at tail of the linked list
            tail.next = curr;
            tail = tail.next;
            // check if there is any next node
            if (curr.next != null) {
                pq.add(curr.next);
            }
        }
        // head is pointing to dummy Node
        // our actual linked list starts from next Node
        return head.next;
        // head
        // -1 -> 1 -> 2 ->3 -> null
    }
 
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
 
    public static void main(String[] args) {
        int K = 3;
        Node[] a = new Node[K];
        Node head1 = new Node(1);
        a[0] = head1;
        head1.next = new Node(3);
        head1.next.next = new Node(5);
        head1.next.next.next = new Node(7);
        Node head2 = new Node(2);
        a[1] = head2;
        head2.next = new Node(4);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(8);
        Node head3 = new Node(0);
        a[2] = head3;
        head3.next = new Node(9);
        head3.next.next = new Node(10);
        head3.next.next.next = new Node(11);
        Node res = mergeKList(a, K);
        if (res != null)
            printList(res);
        System.out.println();
    }
}