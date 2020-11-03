package com.mkv.codingpatterns.inplacereversallinkedlist;

/*
Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized sub-list starting from the head.
If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.

Time complexity #
The time complexity of our algorithm will be O(N) where ‘N’ is the total number of nodes in the LinkedList.

Space complexity #
We only used constant space, therefore, the space complexity of our algorithm is O(1).
*/

public class ReverseEveryKElements {

	private Node reverse(Node head, int k) {
		Node next, current = head, previous = null;
		Node lastPartOfSubList, lastNodeOfPreviousPart ;
		while(true) {
			lastPartOfSubList = current;
			lastNodeOfPreviousPart = previous;
			for(int i = 0; current != null && i < k; i++) {
				next = current.next;
				current.next = previous;
				previous = current;
				current = next;
			}

			if(lastNodeOfPreviousPart != null)
				lastNodeOfPreviousPart.next = previous;
			else
				head = previous;

			lastPartOfSubList.next = current;

			if(current == null)
				break;

			previous = lastPartOfSubList;
		}
		return head;
	}

	public static void main(String[] args) {

		ReverseEveryKElements main = new ReverseEveryKElements();

		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);

		Node result = main.reverse(head, 3);
		System.out.print("Nodes of the reversed LinkedList are: ");
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
	}

}
