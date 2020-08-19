package com.mkv.codingpatterns.cyclicsort;

/*
We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’.
The array has some duplicates, find all the duplicate numbers without using any extra space.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicates {

	private List<Integer> findAllDuplicates(int[] array){
		int i = 0;
		List<Integer> duplicates = new ArrayList<>();
		while(i < array.length) {
			if(array[i] != array[array[i]-1])
				swap(array, i, array[i]-1);
			else
				i++;
		}
		System.out.println(Arrays.toString(array));
		for(int j = 0; j < array.length; j++)
			if(array[j] != j+1)
				duplicates.add(array[j]);

		return duplicates;
	}

	private void swap(int[] array, int i, int j) {
		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args){
		FindAllDuplicates main = new FindAllDuplicates();

		List<Integer> duplicates = main.findAllDuplicates(new int[] {3, 4, 4, 5, 5});
		System.out.println(duplicates);

		duplicates = main.findAllDuplicates(new int[] {5, 4, 7, 2, 3, 5, 3});
		System.out.println(duplicates);
	}
}
