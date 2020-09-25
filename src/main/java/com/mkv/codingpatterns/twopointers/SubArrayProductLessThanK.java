package com.mkv.codingpatterns.twopointers;

/*
Given an array with positive numbers and a target number, find all of its contiguous subarrays
whose product is less than the target number.

Time complexity #
The main for-loop managing the sliding window takes O(N) but creating subarrays can take up to O(N^2) in the worst case.
Therefore overall, our algorithm will take O(N^3).

Space complexity #
Ignoring the space required for the output list, the algorithm runs in O(N) space which is used for the temp list.

*/

import java.util.ArrayList;
import java.util.List;

public class SubArrayProductLessThanK {

	private List<List<Integer>> findSubArray(int[] array, int target) {
		List<List<Integer>> list = new ArrayList<>();
		int product = 1, start = 0, count = 0;

		List<Integer> subList = new ArrayList<>();
		for(int end = 0; end < array.length; end++) {
			product *= array[end];
			while(product >= target && start < array.length) {
				product /= array[start++];

			}
			count += end - start + 1;
			List<Integer> innerList = new ArrayList<>();
			for(int i = start; i <= end; i++){
				innerList.add(array[i]);
				list.add(innerList);
			}

		}
		System.out.println(count);
		return list;
	}

	public static void main(String[] args) {
		SubArrayProductLessThanK main = new SubArrayProductLessThanK();

		System.out.println(main.findSubArray(new int[] { 2, 5, 3, 10 }, 30));
		System.out.println(main.findSubArray(new int[] { 8, 2, 6, 5 }, 50));

	}
}
