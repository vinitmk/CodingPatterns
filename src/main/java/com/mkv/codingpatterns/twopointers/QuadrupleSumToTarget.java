package com.mkv.codingpatterns.twopointers;

/*
Given an array of unsorted numbers and a target number,
find all unique quadruplets in it, whose sum is equal to the target number.

Time complexity #
Sorting the array will take O(N*logN)O(N∗logN). Overall searchQuadruplets() will take O(N * logN + N^3)which is asymptotically equivalent to O(N^3).

Space complexity #
The space complexity of the above algorithm will be O(N)O(N) which is required for sorting.

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrupleSumToTarget {

	private List<List<Integer>> findQuadrupleSumToTarget(int[] array, int target) {
		Arrays.sort(array);
		List<List<Integer>> list = new ArrayList<>();
		for(int i = 0; i < array.length - 3; i++) {
			if(i > 0 && array[i] == array[i - 1] )
				continue;
			for(int j = i+1; j < array.length - 2; j++) {
				if(j > i+1 && array[j] == array[j-1])
					continue;
				searchPairs(array, i, j, target, list);
			}
		}
		return list;
	}

	private void searchPairs(int[] array, int i, int j, int target, List<List<Integer>> list) {
		int currSum, start = j+1; int end = array.length - 1;

		while(start < end) {
			currSum = array[i] + array[j] + array[start] + array[end];
			if(currSum == target) {
				list.add(Arrays.asList(array[i], array[j], array[start], array[end]));
				start++;
				end--;
				while(start < end && array[start] == array[start-1])
					start++;
				while(start < end && array[end] == array[end+1])
					end--;
			}
			else if(currSum < target)
				start++;
			else
				end--;
		}

	}

	public static void main(String[] args) {
		QuadrupleSumToTarget main = new QuadrupleSumToTarget();

		System.out.println(main.findQuadrupleSumToTarget(new int[] { 4, 1, 2, -1, 1, -3 }, 1));
		System.out.println(main.findQuadrupleSumToTarget(new int[] { 2, 0, -1, 1, -2, 2 }, 2));

	}
}
