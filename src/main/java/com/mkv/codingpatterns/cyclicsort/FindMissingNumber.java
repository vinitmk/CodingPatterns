package com.mkv.codingpatterns.cyclicsort;

/*
We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’.
Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.
*/
public class FindMissingNumber {

	private int findMissingNumber(int[] array) {
		int j, i = 0, temp;
		while (i < array.length) {
			if (array[i] < array.length && array[i] != array[array[i]]) {
				j =  array[i];
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
			else
				i++;
		}
		// System.out.println(Arrays.toString(array));
		int c = 0;
		for(int n: array) {
			if (n != c)
				return c;
			c++;
		}
		return -1;
	}


	public static void main(String[] args){
		FindMissingNumber missingNumber = new FindMissingNumber();

		int[] array = new int[] {4, 0, 3, 1};
		int missingNum = missingNumber.findMissingNumber(array);
		System.out.println(missingNum);

		array = new int[] {4, 0, 2, 1, 6, 5, 7};
		missingNum = missingNumber.findMissingNumber(array);
		System.out.println(missingNum);

	}
}
