package com.mkv.codingpatterns.cyclicsort;

/*
Given an unsorted array containing numbers and a number ‘k’,
find the first ‘k’ missing positive numbers in the array.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKMissingPositiveNumbers {

	private List<Integer> findPositiveNumbers(int[] array, int k) {
		int i = 0;
		List<Integer> posNum = new ArrayList<>();

		while(i < array.length) {
			if(array[i] > 0 &&
					array[i] <= array.length &&
					array[i] != array[array[i] - 1])
				swap(array, i, array[i] - 1);
			else
				i++;
		}
		System.out.println(Arrays.toString(array));
		List<Integer> l = new ArrayList<>();
		int n = 0;
		while(k > 0) {
			if(n < array.length) {
				l.add(array[n]);
				if(array[n] != n+1) {
					posNum.add(n+1);
					k--;
				}
				n++;
			}
			else {
				n++;

				if(!l.contains(n)) {
					posNum.add(n);
					k--;
				}
			}
		}
		return posNum;
	}

	private void swap(int[] array, int i, int j) {
		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		FindKMissingPositiveNumbers main = new FindKMissingPositiveNumbers();

		List<Integer> pos = main.findPositiveNumbers(new int[]{3, -1, 4, 5, 5}, 3);
		System.out.println(pos);

		pos = main.findPositiveNumbers(new int[]{3, -1, 4, 5, 5}, 5);
		System.out.println(pos);

		pos = main.findPositiveNumbers(new int[]{2, 3, 4}, 3);
		System.out.println(pos);

		pos = main.findPositiveNumbers(new int[]{-2, -3, 4}, 2);
		System.out.println(pos);



	}
}
