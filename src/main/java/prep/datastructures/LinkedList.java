package prep.datastructures;

import prep.datastructures.linkedlist.Node;

public class LinkedList {

	private Node head;
	private Node tail;
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	public boolean isEmpty() {
		if (head == null && tail == null) return true;
		else if (head != null && tail != null) return false;
		else {
			// Invalid state
			throw new IllegalStateException();
		}
	}
	
	public void append (int data) {
		
		Node newNode = new Node(null, data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		
	}
	
	// Retrieves the data value at a given index in the list.
	public int get(int index) {
		int currentIndex = 0;
		Node currentNode = head;
		while (currentNode != null) {
			if (currentIndex == index) return currentNode.data;
			else {
				currentIndex += 1;
				currentNode = currentNode.next;
			}
		}
		// invalid index
		throw new IndexOutOfBoundsException("Index out of bounds");
	}
	
	// Returns the length of the list
	public int length() {
		int currentIndex = 0;
		Node currentNode = head;
		while (currentNode != null) {
			currentNode = currentNode.next;
			currentIndex += 1;
		}
		return currentIndex;
	}
	
	// Removes the first element in the list with a given data value, if it exists. The list is unchanged
	// if the given value is not in the list. Returns true if an element was removed, false otherwise.
	public boolean remove(int data) {
	
		// list is empty
		if (this.isEmpty()) return false;
		// list has one node
		if (this.length() == 1) {
			if (head.data == data) {
				head = null;
				tail = null;
				return true;
			}
		}
		// list has more than one node
		Node last = head;
		Node current = head.next;
		while (current != null) {
			if (current.data == data) {
				last.next = current.next;
				return true;
			}
			last = current;
			current = current.next;
		}
		return false;
	}
	
	public static LinkedList reverse(LinkedList l) {
		
		if (l.isEmpty()) return new LinkedList();
		
		Node oldHead = l.head;
		Node newHead = new Node(null, oldHead.data);
		Node newTail = newHead;
		while (oldHead.next != null) {
			newHead = new Node(newHead, oldHead.next.data);
			oldHead = oldHead.next;
		}
		
		LinkedList newList = new LinkedList();
		newList.head = newHead;
		newList.tail = newTail;
		return newList;
	}
	
	public static Node recursiveReverse(Node head) {
		
		if (head.next == null) return head;
		else {
			Node tail = recursiveReverse(head.next);
			head.next.next = head;
			head.next = null;
			return tail;
		}
	}
	
}