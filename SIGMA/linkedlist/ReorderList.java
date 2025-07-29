package linkedlist;

import linkedlist.LinkedList.Node;

public class ReorderList {
    public void reorder(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;
        Node curr  = mid.next;
        mid.next= null;
        Node prev = null;
        Node next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL , nextR;
        while(left !=null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right = nextL;

            left = nextL;
            right = nextR;
        }
    }
}
