package com.mkv.codingpatterns.twopointers;

/*
Given an unsorted array of numbers and a target ‘key’, remove all instances of ‘key’ in-place and
return the new length of the array.
*/

import java.util.Arrays;

public class RemoveElement {

	private int removeKeyElement(int[] array, int key) {
		int nextIndex = 0;

		for (int i = 0; i < array.length; i++) {
			if(array[i] != key)
				array[nextIndex++] = array[i];
		}
		System.out.println(Arrays.toString(array));
		return nextIndex;
	}
	public static void main(String[] args) {
		RemoveElement main = new RemoveElement();

		int[] arr = new int[] { 3, 2, 3, 6, 3, 10, 9, 3 };
		System.out.println(main.removeKeyElement(arr, 3));

		arr = new int[] { 2, 11, 2, 2, 1 };
		System.out.println(main.removeKeyElement(arr, 2));


	}
}
