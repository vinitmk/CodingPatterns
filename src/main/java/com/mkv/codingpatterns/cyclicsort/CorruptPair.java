package com.mkv.codingpatterns.cyclicsort;

/*
We are given an unsorted array containing ‘n’ numbers taken from the range 1to ‘n’.
The array originally contained all the numbers from 1to ‘n’,but due to a data error,
one of the numbers got duplicated which also resulted in one number going missing.
Find both these numbers.
*/

import java.util.Arrays;

public class CorruptPair {

	private int[] corruptPair(int[] array) {
		int i = 0;
		while(i < array.length) {
			if(array[i] != array[array[i]-1]) 
				swap(array, i, array[i]-1);
			else
				i++;
		}
		System.out.println(Arrays.toString(array));
		for(int j = 0; j < array.length; j++) {
			if(array[j] != j+1)
				return new int[] {array[j], j+1};
		}
		return new int[] {-1, -1};
	}

	private void swap(int[] array, int i, int j) {
		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		CorruptPair main = new CorruptPair();

		int[] p = main.corruptPair(new int[] {3, 1, 2, 5, 2});
		System.out.println(Arrays.toString(p));

		p = main.corruptPair(new int[] {3, 1, 2, 3, 6, 4});
		System.out.println(Arrays.toString(p));
	}
}
