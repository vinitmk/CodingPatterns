package com.mkv.codingpatterns.twopointers;

/*
Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {

	private List<List<Integer>> searchTriplets(int[] array) {
		Arrays.sort(array);
		List<List<Integer>> tripleList = new ArrayList<>();
		for(int i = 0; i < array.length-2; i++) {
			if(i > 0 && array[i] == array[i - 1])
				continue;
			findPair(array, -array[i],i+1, tripleList);
		}
		return tripleList;
	}

	private void findPair(int[] arr, int targetSum, int start, List<List<Integer>> tripleList) {
		int currentSum, end = arr.length-1;
		List<Integer> list = new ArrayList<>();
		while(start < end) {
			currentSum = arr[start] + arr[end];
			if(targetSum == currentSum) {
				tripleList.add(Arrays.asList(-targetSum, arr[start], arr[end]));
				start++;
				end--;
				while(start < end && arr[start] == arr[start - 1])
					start++;
				while(start < end && arr[end] == arr[end + 1])
					end--;
			}
			else if(targetSum > currentSum)
				start++;
			else
				end--;
		}
	}

	public static void main(String[] args) {

		TripletSumToZero main = new TripletSumToZero();
		List<List<Integer>> list;
		list = main.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 });
		System.out.println(list);
		list = main.searchTriplets(new int[] { -5, 2, -1, -2, 3 });
		System.out.println(list);
	}
}
