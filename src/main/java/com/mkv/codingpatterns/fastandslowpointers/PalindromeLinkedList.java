package com.mkv.codingpatterns.fastandslowpointers;

/*
Given the head of a Singly LinkedList, write a method to check if the LinkedList is a palindrome or not.
Your algorithm should use constant space and the input LinkedList should be in the original form once the algorithm is finished.
The algorithm should have O(N) time complexity where ‘N’ is the number of nodes in the LinkedList.

Time complexity #
The above algorithm will have a time complexity of O(N) where ‘N’ is the number of nodes in the LinkedList.

Space complexity #
The algorithm runs in constant space O(1).

*/

public class PalindromeLinkedList {

	private boolean isPalindrome(ListNode head) {
		ListNode mid = findMiddleOfList(head);
		print(head);
		ListNode revHead = reverseList(mid);
		print(revHead);

		ListNode list1 = head, list2 = revHead;

		while(list1 != null && list2 != null) {
			if(list1.value != list2.value)
				break;
			list1 = list1.next;
			list2 = list2.next;
		}
		reverseList(revHead);
		return list1 == null || list2 == null;
	}

	private ListNode findMiddleOfList(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private void print(ListNode head) {
		ListNode t = head;
		while(t != null) {
			t = t.next;
		}
	}

	private ListNode reverseList(ListNode head) {
		ListNode prevNode = null, nextNode;
		while(head != null) {
			nextNode = head.next;
			head.next = prevNode;
			prevNode = head;
			head = nextNode;
		}
		return prevNode;
	}

	public static void main(String[] args) {

		PalindromeLinkedList main = new PalindromeLinkedList();
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(2);
		System.out.println("Is palindrome: " + main.isPalindrome(head));

		head.next.next.next.next.next = new ListNode(2);
		System.out.println("Is palindrome: " + main.isPalindrome(head));
	}
}
