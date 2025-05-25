package linkedlist;

import linkedlist.DeletionOfANodeInALinkedList.ListNode;


/*
 * Dry run
 * 
 * 
 * // for same length
 *      a
A:     a1 → a2 → a3
                   ↘
                     c1 → c2 → c3 → null
                   ↗            
B:     b1 → b2 → b3
       b
 * 
 * 
 * 
 * 
 *  https://leetcode.com/problems/intersection-of-two-linked-lists/solutions/49785/java-solution-without-knowing-the-difference-in-len/comments/165648/
 * 
 * 
 * It works because pointer A walks through List A and List B (since once it hits null, it goes to List B's head).
   Pointer B also walks through List B and List A.
   Regardless of the length of the two lists, the sum of the lengths are the same (i.e. a+b = b+a), which means that the pointers sync up at the point of intersection.
 */

public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;


        while(a!=b){
            a = a == null  ? headB : a.next;
            b = b == null ? headA : b.next;
        }


        return a;


    }
}
