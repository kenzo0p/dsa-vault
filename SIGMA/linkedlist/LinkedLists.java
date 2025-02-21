package linkedlist;

// this is from live session
public class LinkedList {
    // Node class 
	class Node { 
		int data; 
		Node next; 
 
		Node(int d) 
		{ 
			this.data = d; 
			this.next = null; 
		} 
	}
 
    Node head;
	int size_ll = 0;
 
    // Inserting node at the front 
	public void addFront(int data) 
	{ 
		// Allocating and inserting the data in that node 
		Node newNode = new Node(data); 
 
		// Make the next of the newly allocated node to be 
		// the head 
		newNode.next = head; 
 
		// Now make the head to be the newly allocated node 
		head = newNode; 
 
		size_ll++;
	} 
 
	// Inserting node at the end 
	public void addEnd(int data) 
	{ 
		// Create a new node
        Node newNode = new Node(data);
 
        // If the Linked List is empty, make the new 
        // node as the head
        if (head == null) {
            // Now make the head to be the newly allocated node 
			head = newNode; 
			return;
        }
 
        // Store the head reference in a temporary variable
        Node last = head;
 
        // Traverse till the last node
        while (last.next != null) {
            last = last.next;
        }
 
        // Change the next pointer of the 
        // last node to point to the new node
        last.next = newNode;
 
		size_ll++;
	} 
 
	// function to insert a Node at required position
    public void addAtPos(int position, int data) {
 
		if (position < 1)
            System.out.print("Invalid position");
 
        // if position is 1 then new node is
        // set infornt of head node
        // head node is changing.
        if (position == 1) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        } else {
			Node temp = head;
			int curr_position = 1;
            while (temp != null && curr_position != position - 1 ) {
                temp = temp.next;
				curr_position++;
            }
			if (temp == null) {
				System.out.println("Position " + position + " out of range");
				return;
			}
 
			// adding Node at required position
			Node newNode = new Node(data);
 
			// Making the new Node to point to
			// the old Node at the same position
			newNode.next = temp.next;
 
			// Replacing current with new Node
			// to the old Node to point to the new Node
			temp.next = newNode;
        }
 
		size_ll++;
	}
 
	// Function to delete the head node
    public Node deleteHead()
    {
        // Base case if linked list is empty
        if (head == null)
            return null;
 
        // Move the head to the next node
        head = head.next;
 
        // Return the new head
        return head;
    }
 
	// Function to remove the last node of the linked list
    public Node deleteLastNode()
    {
        // If the list is empty, return null
        if (head == null) {
            return null;
        }
 
        // If the list has only one node, delete it and
        // return null
        if (head.next == null) {
            return null;
        }
 
        // Find the second last node
        Node secondLast = head;
        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }
 
        // Delete the last node
        secondLast.next = null;
 
        return head;
    }
 
	public Node deleteNode(int position)
    {
        Node temp = head;
        Node prev = null;
 
        // Base case if linked list is empty
        if (temp == null)
            return head;
 
        // Case 1: Head is to be deleted
        if (position == 1) {
            head = temp.next;
            return head;
        }
 
        // Case 2: Node to be deleted is in middle
        // Traverse till given position
        for (int i = 1; temp != null && i < position; i++) {
            prev = temp;
            temp = temp.next;
        }
 
        // If given position is found, delete node
        if (temp != null) {
            prev.next = temp.next;
        }
        else {
            System.out.println("Data not present");
        }
 
        return head;
    }
 
	// Checks whether key is present in linked list
    int searchKey(int key) {
 
        // Initialize curr with the head of linked list
        Node curr = head;
		int curr_idx = 1;
 
        // Iterate over all the nodes
        while (curr != null) {
 
            // If the current node's value is equal to key,
            // return true
            if (curr.data == key)
                return curr_idx;
 
            // Move to the next node
            curr = curr.next;
			curr_idx++;
        }
 
        // If there is no node with value as key, return
        // false
        return -1;
    }
 
	public int searchKeyRecursive(int key) {
		return searchKeyRecursiveHelper(head, key);
	}
 
	// Checks whether the key is present in linked list
    public int searchKeyRecursiveHelper(Node head, int key) {
 
        // Base case
        if (head == null)
            return -1;
 
        // If key is present in current node, return true
        if (head.data == key)
            return 0;
 
        // Recur for remaining list
        int idx = searchKeyRecursiveHelper(head.next, key);
 
		// Remaining list doesn't contain the key
		if(idx == -1) {
			return idx;
		}
		// Key was found in remaining list
		return 1 + idx;
    }
 
	public Node reverseList() {
		return reverseListHelper(head);
	}
 
	public Node reverseListHelper(Node head) {
 
        // Initialize three pointers: curr, prev and next
        Node curr = head, prev = null, next;
 
        // Traverse all the nodes of Linked List
        while (curr != null) {
 
            // Store next
            next = curr.next;
 
            // Reverse current node's next pointer
            curr.next = prev;
 
            // Move pointers one position ahead
            prev = curr;
            curr = next;
        }
 
        // Return the head of reversed linked list
        return prev;
    }
 
	Node reverseListRecursive() {
		return reverseListRecursiveHelper(head);
	}
 
	Node reverseListRecursiveHelper(Node head) {
 
		// If we have reached the last node or the linked list is empty, 
		// simply return the head of linked list
		if (head == null || head.next == null)
			return head;
 
		// reverse the rest of linked list and put the first element at the end
		Node rest = reverseListRecursiveHelper(head.next);
 
		// Make the current head as last node of remaining linked list
		head.next.next = head;
 
		// Update next of current head to NULL
		head.next = null;
 
		// Return the reversed linked list
		return rest;
	}
 
	public void deleteNthNodeFromEnd(int n) {
		int nodeFromBeginning = size_ll - n + 1;
		deleteNode(nodeFromBeginning);
	}
 
	// Printing the List 
	public void print() 
	{ 
		Node temp = head; 
		while (temp != null) { 
			System.out.print(temp.data + " "); 
			temp = temp.next; 
		} 
		System.out.println();
	} 
 
	public Node findMiddle(Node head) {
 
        // Initialize the slow and fast pointer to the head
        // of the linked list
        Node slow_ptr = head;
        Node fast_ptr = head;
 
        while (fast_ptr != null && fast_ptr.next != null) {
 
            // Move the fast pointer by two nodes
            fast_ptr = fast_ptr.next.next;
 
            // Move the slow pointer by one node
            slow_ptr = slow_ptr.next;
        }
 
        // Return the slow pointer which is currently
        // pointing to the middle node of the linked list
        return slow_ptr;
    }
 
	boolean isPalindrome()
    {
        if (head != null && head.next != null) {
 
			// Find middle of linked list 
			Node midNode = findMiddle(head);
 
			// Reverse linked list from middle
            Node headSecondList = reverseListHelper(midNode);
 
			while(headSecondList != null) {
				if(headSecondList.data != head.data) {
					return false;
				}
				headSecondList = headSecondList.next;
				head = head.next;
			}
        }
        return true;
    }
 
    public static void main(String args[]) 
	{ 
		// create a linkedlist 
		LinkedList lst = new LinkedList(); 
 
		// insert elements to linked list
		lst.addFront(1);
		lst.addFront(2);
		lst.addFront(2);
		lst.addFront(2);
		// lst.addAtPos(5, 4);
		lst.addFront(1);
 
		// Node newHead = lst.reverseListRecursive();
 
		// Node temp = newHead; 
		// while (temp != null) { 
		// 	System.out.print(temp.data + " "); 
		// 	temp = temp.next; 
		// } 
		// System.out.println();
 
		boolean res = lst.isPalindrome();
		System.out.println(res);
 
		// print the linkedlist 
		lst.print(); 
 
		// lst.deleteHead();
 
		// // print the linkedlist 
		// lst.print(); 
 
		// lst.deleteLastNode();
		// // print the linkedlist 
		// lst.print();
 
		// lst.deleteNode(3);
		// // print the linkedlist 
		// lst.print(); 
	} 
}
 
