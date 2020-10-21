package com.mkv.codingpatterns.fastandslowpointers;

import java.util.HashMap;
import java.util.Map;

public class LinkedListCycleStart {

	private ListNode findCycleStart(ListNode head) {
		int count;
		ListNode slow = head;
		Map<ListNode, Integer> inDegreeMap = new HashMap<>();

		while(slow != null && slow.next != null) {
			count = inDegreeMap.getOrDefault(slow, 0);
			if(count > 1)
				return slow;
			inDegreeMap.put(slow, count+1);
			slow = slow.next;
		}
		return head;
	}

	public static void main(String[] args) {
		LinkedListCycleStart main = new LinkedListCycleStart();

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);

		head.next.next.next.next.next.next = head.next.next;
		System.out.println("LinkedList cycle start: " + main.findCycleStart(head).value);

		head.next.next.next.next.next.next = head.next.next.next;
		System.out.println("LinkedList cycle start: " + main.findCycleStart(head).value);

		head.next.next.next.next.next.next = head;
		System.out.println("LinkedList cycle start: " + main.findCycleStart(head).value);
	}
}
