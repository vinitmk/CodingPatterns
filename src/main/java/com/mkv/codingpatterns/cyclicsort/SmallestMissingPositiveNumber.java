package com.mkv.codingpatterns.cyclicsort;

import java.util.Arrays;

public class SmallestMissingPositiveNumber {

	private int smallestPositiveNumber(int[] array) {
		int i = 0;
		while(i < array.length) {
			if(array[i] > 0 && array[i] < array.length && array[i] != array[array[i] - 1])
				swap(array, i, array[i]-1);
			else
				i++;
		}
		System.out.println(Arrays.toString(array));
		for (int n = 0; n < array.length; n++) {
			if(n+1 != array[n])
				return n+1;
		}
		return -1;
	}

	private void swap(int[] array, int i, int j) {
		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		SmallestMissingPositiveNumber main = new SmallestMissingPositiveNumber();

		int num = main.smallestPositiveNumber(new int[] {-3, 1, 5, 4, 2});
		System.out.println(num);

		num = main.smallestPositiveNumber(new int[] {3, -2, 0, 1, 2});
		System.out.println(num);

		num = main.smallestPositiveNumber(new int[] {-3, 2, 5, 1});
		System.out.println(num);
		
	}
}
