package com.mkv.codingpatterns.slidingwindow;

public class SmallestSubArrayWithSum {

	private int calculateSmallestSubArrayWithSum(int[] array, int sum) {
		int size = Integer.MAX_VALUE, s = 0, start = 0, end;

		for(end = 0; end < array.length; end++) {
			//System.out.println("sum1 "+ s);
			s += array[end];
			while(s >= sum) {
				size = Math.min(size, end - start + 1);
				s -= array[start];
				start++;
			}
		}
		return size;
	}

	public static void main(String[] args) {
		SmallestSubArrayWithSum main = new SmallestSubArrayWithSum();

		int size = main.calculateSmallestSubArrayWithSum(new int[] {2, 1, 5, 2, 3, 2}, 7);
		System.out.println("SubArray size "+ size);

		size = main.calculateSmallestSubArrayWithSum(new int[] {2, 1, 5, 2, 8}, 7);
		System.out.println("SubArray size "+ size);

		size = main.calculateSmallestSubArrayWithSum(new int[] {3, 4, 1, 1, 6}, 8);
		System.out.println("SubArray size "+ size);
	}
}
