package linkedlist;

public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // methods
    public void addFirst(int data) {//o(1)
        // step 1 - create new node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // step 2 - newNode next = head
        newNode.next = head;// link
        // step 3 - head = newNode
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // without tail
    public void addLastl(int data) {
        Node newNode = new Node(data);

        // If the Linked List is empty, make the new
        // node as the head and return
        // if (head == null) {
        // return newNode;
        // }

        // Store the head reference in a temporary variable
        Node last = head;

        // Traverse till the last node
        while (last.next != null) {
            last = last.next;
        }

        // Change the next pointer of the
        // last node to point to the new node
        last.next = newNode;

    }

    public void print() { // o(n)
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        // find the prev node
        // and then for that prev get the next
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        // i = idx - 1; temp -> prev

        // newNode ka next should point temp next
        newNode.next = temp.next;

        // temp next should be newNode so that is point to new node
        temp.next = newNode;
    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        // stroring because we have to return which elem deleted
        int val = head.data;
        // make the next elem as head
        // because my head.next points to the next node so head = head.next
        // garbage collector automatically deletes the first elem that we delete
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        // prev : i = size-2
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;// tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int iterativeSearch(int key) { // -> o(n)
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }

        // key not found case
        return -1;
    }

    public int helper(Node head, int key) { // -> o(n)
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public int recursiveSearch(int key) {
        return helper(head, key);
    }

    public void reverseLL() {

        // prev is head ka index - 1
        Node prev = null;
        // curr is head and we also did tail = head
        Node curr = tail = head;

        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // ! Important question flipkart , adobe , qualcom , amazon
    public void deleteNthfromEnd(int n) {
        // calculate size of ll if we are participating in contest
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }
        // kaaam
        if (n == sz) {
            head = head.next;// remove first operation
            return; // head.next in contest
        }

        // sz-n
        int i = 1;
        int idxToFind = sz - n;// find the exact node from first
        Node prev = head;
        while (i < idxToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return; // head in contest or on leetcode
    }

    // !imp question
    // Slow-Fast approach
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;// +1
            fast = fast.next.next;// +2
        }
        return slow;// slow is my midnode
    }

    public boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true; // if ll is empty or having only one element then its already a palindrome
        }
        // step1-> find mid
        Node middleNode = findMid(head);

        // step2 -> reverse 2nd half
        Node prev = null;
        Node curr = middleNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;// right half head
        Node left = head;// left half head

        // step3 -> check left half & right half for palindrom
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static boolean isCycle() {// floyd's cycle finding algorithm
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true; // cycle exist
            }
        }
        return false; // cycle doesnt exist
    }

    public static void removeCycle() {
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycleExists = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycleExists = true;
                break;
            }
        }
        if (cycleExists == false) {
            return;
        }
        // find meeting point
        slow = head;
        Node prev = null;// last node
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        // remove cycle -> last.next = null;
        prev.next = null;
    }

    // !merge sort in ll

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // find mid
        Node mid = getMid(head);
        // left and right ms
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        // merge
        return merge(newLeft, newRight);
    }


    // !zig zig linked list
    public void  zigZagLL(){
        // find middle 
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        // reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // alt merge  - zig-zag merge
        Node left = head;
        Node right = prev;
        Node nextL , nextR;
        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;


            // updation
            left  = nextL;
            right = nextR;
        }

    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // // ll.head = new Node(1);
        // // ll.head.next = new Node(2);
        // // ll.print();
        // ll.addFirst(2); // -> o(1)
        // // ll.print();
        // ll.addFirst(1);
        // // ll.print();
        // ll.addLast(4); // -> o(1)
        // // ll.print();
        // ll.addLast(5);
        // ll.add(2, 3);
        // ll.print();

        // ll.deleteNthfromEnd(3);
        // ll.print();

        // ll.removeFirst();
        // ll.removeLast();
        // ll.print();// 1->2->3->4->5
        // System.out.println(ll.size);
        // ll.reverseLL();
        // ll.print();
        // System.out.println(ll.recursiveSearch(3));
        // System.out.println(ll.recursiveSearch(10));

        // ll.addLast(1);
        // ll.addLast(1);
        // ll.addLast(1);
        // ll.addLast(1);
        // ll.addLast(1);
        // System.out.println(ll.checkPalindrome());

        // ll lecture 2
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        // // 1->2->3->1
        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());



        // for meger sort  -> o(nlogn)
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.print();
        // ll.head  = ll.mergeSort(ll.head);
        ll.zigZagLL();
        ll.print();

    }
}
