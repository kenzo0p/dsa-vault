package linkedlist;

import linkedlist.DeletionOfANodeInALinkedList.ListNode;

public class ReverseNodeInKPlaces {
         public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null, curr = head, next = null;
        int count = 0;
        
        if (head == null || k == 1) return head;

        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        if (count == k) {
            
            curr = head;

            for (int i = 0; i < k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            if (next != null) {
                head.next = reverseKGroup(next, k);
            }
            
            return prev;

        }

        return head;
    }
}
