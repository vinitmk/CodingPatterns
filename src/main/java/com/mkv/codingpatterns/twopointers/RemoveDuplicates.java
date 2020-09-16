package com.mkv.codingpatterns.twopointers;

/*
Given an array of sorted numbers, remove all duplicates from it.
You should not use any extra space; after removing the duplicates
in-place return the length of the subarray that has no duplicate in it.
*/

import java.util.Arrays;

public class RemoveDuplicates {

	private int remove(int[] array) {
		int nextNonDuplicate = 1; // index of the next non-duplicate element
		for (int i = 1; i < array.length; i++) {
			if (array[nextNonDuplicate - 1] != array[i]) {
				array[nextNonDuplicate] = array[i];
				nextNonDuplicate++;
			}
		}
		System.out.println(Arrays.toString(array));
		return nextNonDuplicate;
	}

	public static void main(String[] args) {
		RemoveDuplicates main = new RemoveDuplicates();

		System.out.println(main.remove(new int[] { 2, 3, 3, 3, 6, 9, 9 }));
		System.out.println(main.remove(new int[] { 2, 2, 2, 11 }));
	}
}
