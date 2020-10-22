package com.mkv.codingpatterns.fastandslowpointers;

/*
Given the head of a Singly LinkedList, write a method to modify the LinkedList
such that the nodes from the second half of the LinkedList are inserted alternately
to the nodes from the first half in reverse order. So if the LinkedList has nodes
1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null, your method should return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.
Your algorithm should not use any extra space and the input LinkedList should be modified in-place.

Time Complexity #
The above algorithm will have a time complexity of O(N) where ‘N’ is the number of nodes in the LinkedList.

Space Complexity #
The algorithm runs in constant space O(1).

*/

public class RearrangeLinkedList {


	private void reorder(ListNode head) {

		ListNode mid = findMiddleOfList(head);
		ListNode revHead = reverseList(mid);

		ListNode half1 = head, temp;
		while(half1 != null && revHead != null) {
			temp = revHead.next;
			revHead.next = half1.next;
			half1.next = revHead;
			half1 = half1.next.next;
			revHead = temp;
		}
		if(half1 != null)
			half1.next = null;
	}

	private ListNode findMiddleOfList(ListNode head) {
		ListNode slow = head, fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private ListNode reverseList(ListNode head) {
		ListNode next, prev = null;
		while(head != null) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

	public static void main(String[] args) {
		RearrangeLinkedList main = new RearrangeLinkedList();
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(8);
		head.next.next.next.next = new ListNode(10);
		head.next.next.next.next.next = new ListNode(12);
		main.reorder(head);
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	}

}
