package linkedlist;

import java.util.HashMap;


public class DeepCopy {
       public Node copyRandomList(Node head) {
        if(head == null) return null;
        HashMap<Node  ,Node>map = new HashMap<>();
        Node curr = head;
        Node prev = null;
        Node newHead = null;
        while(curr!=null){
            Node temp = new Node(curr.val);
            map.put(curr , temp);
            if(newHead == null){
                newHead = temp;
                prev = newHead;
            }else {
                prev.next = temp;
                prev = temp;
            }

            curr = curr.next;
        }
        //fill random pointers 
        curr = head;
        Node newCurr = newHead;
        while(curr != null){
            if(curr.random  == null){
                newCurr.random = null;
            }else {
                newCurr.random = map.get(curr.random);
            }

            curr = curr.next;
            newCurr = newCurr.next;
        }
        return newHead;
    }
}
