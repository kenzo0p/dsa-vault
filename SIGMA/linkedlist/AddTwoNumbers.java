package linkedlist;

import java.util.Stack;

import linkedlist.DeletionOfANodeInALinkedList.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Start with dummy node
        ListNode curr = dummy; // Pointer to build result list
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10; // carry for next digit
            curr.next = new ListNode(sum % 10); // only last digit
            curr = curr.next; // move to next node
        }

        return dummy.next; // skip dummy and return the real head
    }

    // Add two numbers II

    private ListNode reverseLL(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reverseLL(head.next);
        head.next.next = head;
        head.next = null;
        return last;

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseLL(l1);
        l2 = reverseLL(l2);
        int sum = 0;
        int carr = 0;
        ListNode ans = new ListNode();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            ans.val = sum % 10; // 17 -> 7
            carr = sum / 10; // 17 /10 -> 1

            ListNode newNode = new ListNode(carr);
            newNode.next = ans;
            ans = newNode;
            sum = carr;

        }

        return carr == 0 ? ans.next : ans;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode ans = null;

        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int sum = carry;
            if (!s1.isEmpty())
                sum += s1.pop();
            if (!s2.isEmpty())
                sum += s2.pop();

            ListNode newNode = new ListNode(sum % 10);
            newNode.next = ans;
            ans = newNode;

            carry = sum / 10;
        }

        return ans;
    }

}
