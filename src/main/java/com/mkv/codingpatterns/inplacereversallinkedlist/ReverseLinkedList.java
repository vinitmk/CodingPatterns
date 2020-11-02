package com.mkv.codingpatterns.inplacereversallinkedlist;

/*
Given the head of a Singly LinkedList, reverse the LinkedList. Write a function to return the new head of the reversed LinkedList.

Time complexity #
The time complexity of our algorithm will be O(N) where ‘N’ is the total number of nodes in the LinkedList.

Space complexity #
We only used constant space, therefore, the space complexity of our algorithm is O(1).
*/

public class ReverseLinkedList {

	private Node reverse(Node head) {
		Node previous = null, current = head;
		while(current != null) {
			current = head.next;
			head.next = previous;
			previous = head;
			head = current;
		}
		return previous ;
	}

	public static void main(String[] args) {

		ReverseLinkedList main = new ReverseLinkedList();

		Node head = new Node(2);
		head.next = new Node(4);
		head.next.next = new Node(6);
		head.next.next.next = new Node(8);
		head.next.next.next.next = new Node(10);

		Node result = main.reverse(head);

		System.out.print("Nodes of the reversed LinkedList are: ");
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
	}

}
