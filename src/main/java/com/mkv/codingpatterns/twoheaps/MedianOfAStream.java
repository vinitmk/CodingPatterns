package com.mkv.codingpatterns.twoheaps;

/*
Design a class to calculate the median of a number stream. The class should have the following two methods:
		insertNum(int num): stores the number in the class
		findMedian(): returns the median of all numbers inserted in the class

If the count of numbers inserted in the class is even, the median will be the average of the middle two numbers.

Time complexity #
The time complexity of the insertNum() will be O(logN)O(logN) due to the insertion in the heap. The time complexity of the findMedian() will be O(1)O(1) as we can find the median from the top elements of the heaps.

Space complexity #
The space complexity will be O(N)O(N) because, as at any time, we will be storing all the numbers.
*/

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfAStream {

	private PriorityQueue<Integer> maxHeap;
	private PriorityQueue<Integer> minHeap;

	private MedianOfAStream() {
		maxHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));
		minHeap = new PriorityQueue<>((a, b) -> b - a);
	}

	private void insertNum(int num) {
		if(maxHeap.isEmpty() || maxHeap.peek() > num)
			maxHeap.add(num);
		else
			minHeap.add(num);

		if(maxHeap.size() > minHeap.size() + 1)
			minHeap.add(maxHeap.poll());
		else if(maxHeap.size() < minHeap.size())
			maxHeap.add(minHeap.poll());
	}

	private float findMedian() {
		float median = 0;
		if(minHeap.size() == maxHeap.size()) {
			if(minHeap.peek() != null || maxHeap.peek() != null)
				median = (float) (minHeap.peek() + maxHeap.peek()) / 2;
			return median;
		}
		if(maxHeap.peek() != null)
			median = maxHeap.peek();
		return median;
	}

	public static void main(String[] args) {
		MedianOfAStream medianOfAStream = new MedianOfAStream();

		medianOfAStream.insertNum(3);
		medianOfAStream.insertNum(1);
		System.out.println("The median is: " + medianOfAStream.findMedian());
		medianOfAStream.insertNum(5);
		System.out.println("The median is: " + medianOfAStream.findMedian());
		medianOfAStream.insertNum(4);
		System.out.println("The median is: " + medianOfAStream.findMedian());
	}

}
