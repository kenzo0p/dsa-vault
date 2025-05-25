package linkedlist;

import linkedlist.DeletionOfANodeInALinkedList.ListNode;;

public class OddEvenLL {
    // Leetcode 328

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        /*
         * Story :
         * 1. Hume odd and even ko segregate karna hai
         * 2. To let's take two pointers to point to ODD and EVEN nodes
         * 3. Unko alag alag segregate kardenge
         * 4. Last me connect kardenge odd ko even se
         * 
         */

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenStart = head.next;
        while (even != null && even.next != null) {
            odd.next = even.next;
            even.next = even.next.next; // fat sakta hain ye code

            // increament odd and even of there new next
            odd = odd.next;
            even = even.next;
        }
        //then we have to connect it 
        // a,b,c -> d,e
        odd.next = evenStart;
        return head;
    }



    




}
