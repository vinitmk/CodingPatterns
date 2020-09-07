package com.mkv.codingpatterns.slidingwindow;

/*
Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
find the length of the longest contiguous subarray having all 1s.
*/

import java.util.HashMap;
import java.util.Map;

public class ReplacingOnes {

	private int findLongestOnes(int[] array, int k) {
		int start = 0, maxOneCount = 0, maxLongestOne = 0;
		for(int end = 0; end < array.length; end++) {
			if(array[end] == 1)
				maxOneCount++;

			if(end - start + 1 - maxOneCount > k) {
				if(array[start] ==  1)
					maxOneCount--;
				start++;
			}
			maxLongestOne = Math.max(maxLongestOne, end - start + 1);
		}
		return maxLongestOne;
	}



	public static void main(String[] args) {
		ReplacingOnes main = new ReplacingOnes();

		System.out.println(main.findLongestOnes(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
		System.out.println(main.findLongestOnes(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
	}
}
