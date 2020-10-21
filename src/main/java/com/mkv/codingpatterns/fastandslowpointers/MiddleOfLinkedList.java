package com.mkv.codingpatterns.fastandslowpointers;

/*
Given the head of a Singly LinkedList, write a method to return the middle node of the LinkedList.
If the total number of nodes in the LinkedList is even, return the second middle node.

Time complexity #
The above algorithm will have a time complexity of O(N) where ‘N’ is the number of nodes in the LinkedList.

Space complexity #
The algorithm runs in constant space O(1).
*/

public class MiddleOfLinkedList {

	private ListNode findMiddle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static void main(String[] args) {

		MiddleOfLinkedList main = new MiddleOfLinkedList();

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		System.out.println("Middle Node: " + main.findMiddle(head).value);

		head.next.next.next.next.next = new ListNode(6);
		System.out.println("Middle Node: " + main.findMiddle(head).value);

		head.next.next.next.next.next.next = new ListNode(7);
		System.out.println("Middle Node: " + main.findMiddle(head).value);
	}
}
