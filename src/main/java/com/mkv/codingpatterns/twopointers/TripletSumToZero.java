package com.mkv.codingpatterns.twopointers;

/*
Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {

	private List<List<Integer>> searchTriplets(int[] array) {

		List<List<Integer>> tripleList = new ArrayList<>();
		for(int i = 0; i < array.length-2; i++) {
			if(i > 0 && array[i] == array[i - 1])
				continue;
			findPair(array[i], i+1, array, tripleList);
		}
		return tripleList;
	}

	private void findPair(int num, int start, int[] array, List<List<Integer>> tripleList) {
		int sum, end = array.length-1;
		List<Integer> list = new ArrayList<>();
		num *= -1;
		//System.out.println(" sum " + num);
		while(start < end) {
			sum = array[start] + array[end];
			if(num == sum) {
				tripleList.add(Arrays.asList(-num, array[start], array[end]));
				break;
			}
			else if(num < sum)
				end--;
			else
				start++;
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
