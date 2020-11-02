package com.mkv.codingpatterns.inplacereversallinkedlist;

/*
Given the head of a LinkedList and two positions ‘p’ and ‘q’, reverse the LinkedList from position ‘p’ to ‘q’.

Time complexity #
The time complexity of our algorithm will be O(N) where ‘N’ is the total number of nodes in the LinkedList.

Space complexity #
We only used constant space, therefore, the space complexity of our algorithm is O(1).

*/

public class ReverseSubList {

  private Node reverseSubList(Node head, int p, int q) {

    if (p == q) return head;

    Node current = head, previous = null;

    for (int i = 0; current != null && i < p - 1; ++i) {
      previous = current;
      current = current.next;
    }

    Node lastNodeOfFirstPart = previous;
    Node lastNodeOfSubList = current;
    Node next;
    for (int i = 0; current != null && i < q - p + 1; i++) {
      next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }

    if (lastNodeOfFirstPart != null) lastNodeOfFirstPart.next = previous;
    else head = previous;

    assert lastNodeOfSubList != null;
    lastNodeOfSubList.next = current;

    return head;
  }



  public static void main(String[] args) {
    ReverseSubList main = new ReverseSubList();

    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);

    Node result = main.reverseSubList(head, 2, 4);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
  }
}
