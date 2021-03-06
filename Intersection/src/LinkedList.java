
// Java program to implement
// a Singly Linked List

public class LinkedList {

	Node head; // head of list

	// Linked list Node.
	// This inner class is made static
	// so that main() can access it
	static class Node {

		int data;
		Node next;

		// Constructor
		Node(int d) {
			data = d;
			next = null;
		}
	}

	// Method to insert a new node
	public static LinkedList insert(LinkedList list, int data) {
		// Create a new node with given data
		Node new_node = new Node(data);
		new_node.next = null;

		// If the Linked List is empty,
		// then make the new node as head
		if (list.head == null) {
			list.head = new_node;
		} else {
			// Else traverse till the last node
			// and insert the new_node there
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}

			// Insert the new_node at last node
			last.next = new_node;
		}

		// Return the list by head
		return list;
	}

	// Method to print the LinkedList.
	public static void printList(LinkedList list) {
		Node currNode = list.head;

		System.out.print("LinkedList: ");

		// Traverse through the LinkedList
		while (currNode != null) {
			// Print the data at current node
			System.out.print(currNode.data + " ");

			// Go to next node
			currNode = currNode.next;
		}
	}

	// Method to get a value of the node where two linked lists intersect
	public static Integer getIntersectionNode(Node headA, Node headB) {

		if (headA == null || headB == null)
			return null;

		Node a_pointer = headA;
		Node b_pointer = headB;

		while (a_pointer != b_pointer) {
			if (a_pointer == null) {
				a_pointer = headB;
			} else {
				a_pointer = a_pointer.next;

			}
			if (b_pointer == null) {
				b_pointer = headA;
			} else {
				b_pointer = b_pointer.next;

			}
		}
		return a_pointer.data;
	}


	public static void main(String[] args) {
		/* Start with the empty list. */
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();

		//
		// ******INSERTION******
		//
		// Insert the values
		list1 = insert(list1, 1);
		list1 = insert(list1, 2);
		list1 = insert(list1, 3);
		list1 = insert(list1, 4);
		list1 = insert(list1, 5);
		list1 = insert(list1, 6);
		list1 = insert(list1, 7);
		list1 = insert(list1, 8);
		// Print the Linkedlist1
		System.out.println("list1:");
		printList(list1);

		System.out.println();
		System.out.println();

		list2 = insert(list2, 8);
		list2 = insert(list2, 7);
		list2 = insert(list2, 6);
		list2.head.next.next.next = list1.head.next.next.next.next;

		// Print the Linkedlist2
		System.out.println("list2:");
		printList(list2);

		System.out.println();
		System.out.println();

		System.out.println("Intersecting node:");
		System.out.println(getIntersectionNode(list1.head, list2.head));
	}
}
