package com.mkv.codingpatterns.fastandslowpointers;

/*
Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.

Time Complexity #
As we have concluded above, once the slow pointer enters the cycle, the fast pointer will meet the slow pointer in the same loop.
Therefore, the time complexity of our algorithm will be O(N) where ‘N’ is the total number of nodes in the LinkedList.

Space Complexity #
The algorithm runs in constant space O(1).
*/

public class LinkedListCycle {
	private int cycleLength = 0;

	private boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(fast == slow) {
				calculateCycleLength(slow);
				return true;
			}
		}
		return false;
	}

	private void calculateCycleLength(ListNode head) {
		cycleLength = 0;
		ListNode current = head;
		do{
			++cycleLength;
			current = current.next;
		} while(current != head);
	}

	public static void main(String[] args) {
		boolean hasCycle;
		LinkedListCycle main = new LinkedListCycle();

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		hasCycle = main.hasCycle(head);
		System.out.println("LinkedList has cycle: " + hasCycle);
		if(hasCycle)
			System.out.println("Cycle Length " + main.cycleLength);


		head.next.next.next.next.next.next = head.next.next;
		hasCycle = main.hasCycle(head);
		System.out.println("LinkedList has cycle: " + hasCycle);
		if(hasCycle)
			System.out.println("Cycle Length " + main.cycleLength);


		head.next.next.next.next.next.next = head.next.next.next;
		hasCycle = main.hasCycle(head);
		System.out.println("LinkedList has cycle: " + hasCycle);
		if(hasCycle)
			System.out.println("Cycle Length " + main.cycleLength);
	}
}
