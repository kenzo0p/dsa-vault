package linkedlist;

public class DeletionOfANodeInALinkedList {
    static class ListNode {
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void delete(ListNode node) {
        ListNode prev = null;
        while (node != null && node.next != null) {
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }

        if (node != null) {
            if (prev != null) {
                prev.next = null;
            } else {
                node = null;
            }
        }

    }

}
