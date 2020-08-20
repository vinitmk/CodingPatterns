package com.mkv.codingpatterns.slidingwindow;

/*
Given an array of positive numbers and a positive number ‘k’,
find the maximum sum of any contiguous subarray of size ‘k’.
*/

public class MaximumSumOfSubArray {


	private int calculateMaxSumOfSubArray(int[] array, int k) {
		int start = 0, maxSum = Integer.MIN_VALUE, sum = 0;

		for(int end = 0; end < array.length; end++) {
			sum += array[end];

			if(end >= k-1) {
				if(sum > maxSum)
					maxSum = sum;
				sum -= array[start];
				start++;
			}

		}

		return maxSum;
	}

	public static void main(String[] args) {
		MaximumSumOfSubArray main = new MaximumSumOfSubArray();

		int sum = main.calculateMaxSumOfSubArray(new int[] {2, 1, 5, 1, 3, 2}, 3);
		System.out.println("Maximum Sum  = "+ sum);

		sum = main.calculateMaxSumOfSubArray(new int[] {2, 3, 4, 1, 5}, 2);
		System.out.println("Maximum Sum  = "+ sum);
	}
}
