package com.mkv.codingpatterns.cyclicsort;

/*
We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’.
The array has only one duplicate but it can be repeated multiple times.
Find that duplicate number without using any extra space.
You are, however, allowed to modify the input array.
*/

import java.util.Arrays;

public class FindDuplicateNumbers {

	private int findDuplicate(int[] array){
		int i = 0;
		while(i < array.length) {
			if (array[i] != i+1)
				if(array[i] != array[array[i]])
					swap(array, i, array[i]);
				else
					return array[i];
			else
				i++;
		}
		return -1;
	}

	private void swap(int[] array, int i, int j) {
		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;

	}

	public static void main(String[] args){
		FindDuplicateNumbers main = new FindDuplicateNumbers();

		int[] array = new int[] {1, 4, 4, 3, 2};
		int duplicate = main.findDuplicate(array);
		System.out.println("Duplicate : "+ duplicate);


	}
}
