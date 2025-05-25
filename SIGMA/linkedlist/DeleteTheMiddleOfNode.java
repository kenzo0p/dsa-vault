package linkedlist;

import linkedlist.DeletionOfANodeInALinkedList.ListNode;

public class DeleteTheMiddleOfNode {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prevSlow = null;
        while (fast != null && fast.next != null) {
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prevSlow == null) {
            return null;
        }

        prevSlow.next = slow.next;
        return head;
    }
}
