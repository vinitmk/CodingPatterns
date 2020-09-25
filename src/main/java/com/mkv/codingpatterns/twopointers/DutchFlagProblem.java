package com.mkv.codingpatterns.twopointers;

/*
Given an array containing 0s, 1s and 2s, sort the array in-place.
You should treat numbers of the array as objects,
hence, we can’t count 0s, 1s, and 2s to recreate the array.

Time complexity #
The time complexity of the above algorithm will be O(N) as we are iterating the input array only once.

Space complexity #
The algorithm runs in constant space O(1)

*/

import java.util.Arrays;

public class DutchFlagProblem {

	private void sort(int[] array) {
		int index = 0, low = 0, high = array.length - 1;

		while(index <= high) {
			if(array[index] == 0) {
				swap(array, low, index);
				low++;
				index++;
			}
			else if(array[index] == 1)
				index++;
			else {
				swap(array, high, index);
				high--;
			}
		}
		System.out.println(Arrays.toString(array));
	}

	private void swap(int[] array, int i, int j) {
		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {

		DutchFlagProblem main = new DutchFlagProblem();
		int[] arr = new int[] { 1, 0, 2, 1, 0 };
		main.sort(arr);

		arr = new int[] { 2, 2, 0, 1, 2, 0, 1 };
		main.sort(arr);

	}
}
