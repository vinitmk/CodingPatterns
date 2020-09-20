package com.mkv.codingpatterns.twopointers;

/*
Given an array arr of unsorted numbers and a target sum, count all triplets in it such that arr[i] + arr[j] + arr[k] < target
where i, j, and k are three different indices. Write a function to return the count of such triplets.
*/


import java.util.Arrays;

public class TripletWithSmallerSum {

	private int getCountOfTriplets(int[] array, int target) {
		int count = 0;
		Arrays.sort(array);
		for(int i = 0; i < array.length - 2; i++) {
			count += findPair(array, target - array[i], i+1);
		}
		return count;
	}

	private int findPair(int[] array, int targetSum, int start) {
		int sum, count = 0, end = array.length - 1;
		System.out.print(Arrays.toString(array) +" START "+start +" sum " +targetSum);

		while(start < end) {
			sum = array[start] + array[end];
			if(sum < targetSum) {
				count += end - start;
				start++;
			}
			else
				end--;
		}
		return count;
	}

	public static void main(String[] args) {
		TripletWithSmallerSum main = new TripletWithSmallerSum();

		System.out.println(main.getCountOfTriplets(new int[] { -1, 0, 2, 3 }, 3));
		System.out.println(main.getCountOfTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));

	}





}
