package com.mkv.codingpatterns.bitmanipulation;

public class CheckKthBitSetOrNot {

	private boolean getKthBitUsingLeftShift(int n, int k) {
		return (n & (1 << (k-1))) != 0;
	}

	private boolean getKthBitUsingRightShift(int n, int k) {
		return ((n >> (k-1)) & 1) == 1;
	}

	public static void main(String[] args) {
		CheckKthBitSetOrNot main = new CheckKthBitSetOrNot();

		boolean k = main.getKthBitUsingLeftShift(5, 3);
		System.out.println(k);
		System.out.println("n = 10, k = 2 : " + main.getKthBitUsingLeftShift(10, 2));

		System.out.println("n = 10, k = 2 : " + main.getKthBitUsingRightShift(10, 2));
		System.out.println("n = 10, k = 1 : " + main.getKthBitUsingRightShift(10, 1));
	}

}
