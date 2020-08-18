package com.mkv.codingpatterns.cyclicsort;
// Pattern: Cyclic Sort
//Write a function to sort the objects in-place on their
// creation sequence number in O(n) and without any extra space.
// For simplicity, let’s assume we are passed an integer array containing
// only the sequence numbers

import java.util.Arrays;

public class CyclicSort {

	private void sortInPlace(int[] array){
		int i = 0, temp;
		while(i < array.length){
			if(array[i] != array[array[i]-1]) {
				temp = array[array[i]-1];
				array[array[i]-1] = array[i];
				array[i] = temp;
			}
			else
				i++;
		}
	}

	public static void main(String[] args) {
		CyclicSort sort = new CyclicSort();

		int[] array = new int[] {4,5,3,1,2};
		sort.sortInPlace(array);
		System.out.println(Arrays.toString(array));

		array = new int[] {4,5,3,1,2,7,6,9,8};
		sort.sortInPlace(array);
		System.out.println(Arrays.toString(array));
	}
}
