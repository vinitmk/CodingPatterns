package com.mkv.codingpatterns.twopointers;

/*
Given an array of unsorted numbers and a target number, find a triplet in the array
whose sum is as close to the target number as possible, return the sum of the triplet.
If there are more than one such triplet, return the sum of the triplet with the smallest sum.

Sorting the array will take O(N* logN)O(N∗logN). Overall searchTriplet() will take O(N * logN + N^2)
which is asymptotically equivalent to O(N^2)

Space complexity #
The space complexity of the above algorithm will be O(N) which is required for sorting.
*/

import java.util.Arrays;

public class TripletSumCloseToTarget {

	private int findTripletSum(int[] array, int target) {
		int start, end, diff, smallestDiff = Integer.MAX_VALUE;
		Arrays.sort(array);
		for(int i = 0; i < array.length - 2; i++) {
			start = i + 1; end = array.length -1;
			while(start < end) {
				diff = target - array[i] - array[start] - array[end];
				if(diff == 0)
					return target - diff;
				if(Math.abs(smallestDiff) > Math.abs(diff) ||
						(Math.abs(smallestDiff) == Math.abs(diff)) && target > smallestDiff)
					smallestDiff = diff;

				if(diff > 0)
					start++;
				else
					end--;
			}

		}
		return target - smallestDiff;
	}

	public static void main(String[] args) {

		TripletSumCloseToTarget main = new TripletSumCloseToTarget();

		System.out.println(main.findTripletSum(new int[] { -2, 2, 1, 3 }, 4));
		System.out.println(main.findTripletSum(new int[] { -3, -1, 1, 2 }, 1));
		System.out.println(main.findTripletSum(new int[] { 1, 0, 1, 1 }, 100));


	}
}
