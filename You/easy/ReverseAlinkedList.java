package You.easy;

public class ReverseAlinkedList {
    Node reverseList(Node head) {
        // code here
        Node curr = head;
        Node prev = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
}
