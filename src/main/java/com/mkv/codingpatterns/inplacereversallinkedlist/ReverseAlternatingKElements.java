package com.mkv.codingpatterns.inplacereversallinkedlist;

/*
Given the head of a LinkedList and a number ‘k’, reverse every alternating ‘k’ sized sub-list starting from the head.
If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.

Time complexity #
The time complexity of our algorithm will be O(N) where ‘N’ is the total number of nodes in the LinkedList.

Space complexity #
We only used constant space, therefore, the space complexity of our algorithm is O(1).

*/

public class ReverseAlternatingKElements {

  private Node reverse(Node head, int k) {

    Node lastNodeOfSubList, lastNodeOfPreviousPart, next, current = head, previous = null;

    do {
      lastNodeOfSubList = current;
      lastNodeOfPreviousPart = previous;
      for (int i = 0; current != null && i < k; i++) {
        next = current.next;
        current.next = previous;
        previous = current;
        current = next;
      }

      if (lastNodeOfPreviousPart != null) lastNodeOfPreviousPart.next = previous;
      else head = previous;

      lastNodeOfSubList.next = current;

      for (int i = 0; current != null && i < k; ++i) {
        previous = current;
        current = current.next;
      }

    }
    while (current != null);

    return head;
  }

  public static void main(String[] args) {

    ReverseAlternatingKElements main = new ReverseAlternatingKElements();

    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);
    head.next.next.next.next.next = new Node(6);
    head.next.next.next.next.next.next = new Node(7);
    head.next.next.next.next.next.next.next = new Node(8);

    Node result = main.reverse(head, 2);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
  }
}
