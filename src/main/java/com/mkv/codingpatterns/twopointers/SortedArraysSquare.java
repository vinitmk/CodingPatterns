package com.mkv.codingpatterns.twopointers;

/*
Given a sorted array, create a new array containing squares of all the number of the input array
in the sorted order.

Time complexity #
The time complexity of the above algorithm will be O(N)O(N) as we are iterating the input array only once.

Space complexity #
The space complexity of the above algorithm will also be O(N)O(N); this space will be used for the output array.

*/

import java.util.Arrays;

public class SortedArraysSquare {

	private int[] squareArray(int[] array) {
		int front = 0, end = array.length-1, index = array.length-1;
		int sq1, sq2;
		int[] squares = new int[array.length];

		while(front <= end) {
			sq1 = (int)Math.pow(array[front], 2);
			sq2 = (int)Math.pow(array[end], 2);

			if(sq1 >= sq2) {
				squares[index--] = sq1;
				front++;
			}
			else {
				squares[index--] = sq2;
				end--;
			}
		}

		return squares;
	}

	public static void main(String[] args) {
		SortedArraysSquare main = new SortedArraysSquare();

		System.out.println(Arrays.toString(main.squareArray(new int[] { -2, -1, 0, 2, 3 })));
		System.out.println(Arrays.toString(main.squareArray(new int[] { -3, -1, 0, 1, 2})));
	}
}
