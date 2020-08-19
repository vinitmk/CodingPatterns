package com.mkv.codingpatterns.cyclicsort;

/*
We are given an unsorted array containing numbers taken from the range 1 to ‘n’.
The array can have duplicates, which means some numbers will be missing.
Find all those missing numbers.
*/

import java.util.ArrayList;
import java.util.List;

public class FindAllMissingNumbers {

	private List<Integer> findAllMissingNumbers(int[] array){
		List<Integer> missingNumbers = new ArrayList<>();

		sortInPlace(array);
		for (int i = 0; i < array.length; i++) {
			if(array[i] != i+1)
				missingNumbers.add(i+1);
		}
		return missingNumbers;
	}

	private void sortInPlace(int[] array){
		int i = 0;
		while(i < array.length){
			if(array[i] != array[array[i]-1]) {
				swap(array, i, array[i]-1);
			}
			else
				i++;
		}
	}

	private void swap(int[] array, int i, int j) {
		int temp;
		temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}

	public static void main(String[] args) {
		List<Integer> list;
		FindAllMissingNumbers main = new FindAllMissingNumbers();

		int[] array = new int[] {2, 3, 1, 8, 2, 3, 5, 1};
		list = main.findAllMissingNumbers(array);
		System.out.println("Missing numbers: " + list);

		list = main.findAllMissingNumbers(new int[] { 2, 4, 1, 2 });
		System.out.println("Missing numbers: " + list);

		list = main.findAllMissingNumbers(new int[] { 2, 3, 2, 1 });
		System.out.println("Missing numbers: " + list);
	}
}
