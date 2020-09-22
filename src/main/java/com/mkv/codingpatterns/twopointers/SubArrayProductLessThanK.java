package com.mkv.codingpatterns.twopointers;

/*
Given an array with positive numbers and a target number, find all of its contiguous subarrays
whose product is less than the target number.
*/

import java.util.ArrayList;
import java.util.List;

/*
Given an array with positive numbers and a target number, find all of its contiguous subarrays
whose product is less than the target number.
*/

public class SubArrayProductLessThanK {

	private List<List<Integer>> findSubArray(int[] array, int target) {
		List<List<Integer>> list = new ArrayList<>();
		int product = 1, start = 0;

		List<Integer> subList = new ArrayList<>();
		for(int end = 0; end < array.length; end++) {
			product *= array[end];
			while(product >= target && start < array.length) {


			}

		}
		return list;
	}

	public static void main(String[] args) {
		SubArrayProductLessThanK main = new SubArrayProductLessThanK();

		System.out.println(main.findSubArray(new int[] { 2, 5, 3, 10 }, 30));
		System.out.println(main.findSubArray(new int[] { 8, 2, 6, 5 }, 50));

	}
}
