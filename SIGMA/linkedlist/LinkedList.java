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
    public void addFirst(int data) {
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
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        // i = idx - 1; temp -> prev
        newNode.next = temp.next;
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
        int val = head.data;
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
        Node prev = null;
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
            return;
        }

        // sz-n
        int i = 1;
        int idxToFind = sz - n;
        Node prev = head;
        while (i < idxToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
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

    public boolean checkPalindrome(){
        if(head == null || head.next == null){
            return true; //if ll is empty or having only one element then its already a palindrome
        }
        // step1-> find mid
        Node middleNode = findMid(head);
        
        // step2 -> reverse 2nd half
        Node prev = null;
        Node curr = middleNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;//right half head
        Node left = head;//left half head

        // step3 -> check left half & right half for palindrom
        while(right !=null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
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
        
        
        ll.addLast(1);
        ll.addLast(1);
        ll.addLast(1);
        ll.addLast(1);
        ll.addLast(1);
        System.out.println(ll.checkPalindrome());


    }
}
