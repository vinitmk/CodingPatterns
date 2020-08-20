package com.mkv.codingpatterns.slidingwindow;

/* Given an array, find the average of all contiguous subarrays of size ‘K’ in it. */

import java.util.Arrays;

public class AverageOfKSubArrays {

	private double[] calculateAverage(int[] array, int k) {
		double[] average = new double[array.length - k + 1];
		int start = 0, end;
		double sum = 0;

		for(end = 0; end < array.length; end++) {
			sum += array[end];

			if(end >= k-1) {
				average[start] = sum/k;
				sum -= array[start];
				start++;
			}
		}
		return average;
	}

	public static void main(String[] args) {
		AverageOfKSubArrays main = new AverageOfKSubArrays();

		double[] avg = main.calculateAverage(new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 }, 5);
		System.out.println(Arrays.toString(avg));
	}
}
