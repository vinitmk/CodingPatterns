package com.mkv.codingpatterns.twopointers;

/*
Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.

Time complexity #
The time complexity of the above algorithm will be O(N).

Space complexity #
The algorithm runs in constant space O(1).
*/


public class ShortestWindowSort {

	private int findSubArray(int[] array) {
		int low = 0; int high = array.length - 1;

		while(low < array.length - 1 && array[low] <= array[low + 1])
			low++;

		if(low == array.length - 1)
			return 0;

		while(high >=0 && array[high] >= array[high-1])
			high--;

		int subArrayMax = Integer.MIN_VALUE;
		int subArrayMin = Integer.MAX_VALUE;
		for(int i = low; i <= high; i++) {
			subArrayMax = Math.max(subArrayMax, array[i]);
			subArrayMin = Math.min(subArrayMin, array[i]);
		}

		while(low > 0 && array[low - 1] >= subArrayMin)
			low--;

		while(high < array.length -1 && array[high + 1] <= subArrayMax)
			high++;

		return high - low + 1;
	}

	public static void main(String[] args) {
		ShortestWindowSort main = new ShortestWindowSort();

		System.out.println(main.findSubArray(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
		System.out.println(main.findSubArray(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
		System.out.println(main.findSubArray(new int[] { 1, 2, 3 }));
		System.out.println(main.findSubArray(new int[] { 3, 2, 1 }));
	}
}
