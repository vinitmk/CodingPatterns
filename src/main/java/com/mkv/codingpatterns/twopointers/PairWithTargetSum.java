package com.mkv.codingpatterns.twopointers;

/* Given an array of sorted numbers and a target sum,
find a pair in the array whose sum is equal to the given target.
*/

public class PairWithTargetSum {

	private int[] searchPair(int[] array, int sum) {
		int currentSum, left = 0, right = array.length - 1;
		while(left < right) {
			currentSum = array[left] + array[right];
			if(currentSum == sum)
				return new int[] {left, right};
			else if (currentSum < sum)
				left++;
			else
				right--;
		}
		return new int[] {-1, -1};
	}

	public static void main(String[] args) {

		PairWithTargetSum main = new PairWithTargetSum();
		int[] result = main.searchPair(new int[] { 1, 2, 3, 4, 6 }, 6);
		System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
		result = main.searchPair(new int[] { 2, 5, 9, 11 }, 11);
		System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");

	}
}
