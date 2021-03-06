package com.mkv.codingpatterns.bitmanipulation;

public class CheckKthBitSetOrNot {

	private boolean getKthBit(int n, int k) {
		return (n & (1 << (k-1))) != 0;
	}

	public static void main(String[] args) {
		CheckKthBitSetOrNot main = new CheckKthBitSetOrNot();

		boolean k = main.getKthBit(5, 3);
		System.out.println(k);
		System.out.println("n = 10, k = 2 : " + main.getKthBit(10, 2));
	}

}
