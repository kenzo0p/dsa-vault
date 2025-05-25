package linkedlist;

import java.util.ArrayList;
import java.util.Collections;

import linkedlist.DeletionOfANodeInALinkedList.ListNode;

public class SortLL {
    public ListNode sortList(ListNode head) {
        ListNode temp = head;
        ArrayList<Integer> arr = new ArrayList<>();
        while (temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }
        Collections.sort(arr);
        temp = head;
        for (int i = 0; i < arr.size(); i++) {
            temp.val = arr.get(i);
            temp = temp.next;
        }

        return head;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    /*
     * 
     * 
     * Check base case – if list has 0 or 1 node, return it
     * 
     * Find middle node using slow & fast pointer
     * 
     * Break the list into two halves (set mid.next = null)
     * 
     * Sort left half (recursive call)
     * 
     * Sort right half (recursive call)
     * 
     * Merge both sorted halves
     * 
     * Return the merged list.next
     * 
     */
    class Solution {
        // using merge sort
        private ListNode getMid(ListNode head) {
            ListNode slow = head;
            ListNode fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        private ListNode merge(ListNode left, ListNode right) {
            ListNode mergedLL = new ListNode(-1);
            ListNode temp = mergedLL;
            while (left != null && right != null) {
                if (left.val <= right.val) {
                    temp.next = left;
                    left = left.next;
                    temp = temp.next;
                } else {
                    temp.next = right;
                    right = right.next;
                    temp = temp.next;
                }
            }

            while (left != null) {
                temp.next = left;
                temp = temp.next;
                left = left.next;
            }
            while (right != null) {
                temp.next = right;
                temp = temp.next;
                right = right.next;
            }
            return mergedLL.next;

        }

        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode mid = getMid(head);
            ListNode rightHead = mid.next;
            mid.next = null;
            ListNode newLeft = sortList(head);
            ListNode newRight = sortList(rightHead);

            return merge(newLeft, newRight);
        }
    }

}
