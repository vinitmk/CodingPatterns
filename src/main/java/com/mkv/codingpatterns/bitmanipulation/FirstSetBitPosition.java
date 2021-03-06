package com.mkv.codingpatterns.bitmanipulation;

public class FirstSetBitPosition {

	private int getFirstSetBit(int n) {
		int k = 1;
		while(true) {
			if((n & (1 << k-1)) == 0)
				k++;
			else
				return k;
		}
	}

	public static void main(String[] args) {

		FirstSetBitPosition main = new FirstSetBitPosition();

		System.out.println("First setbit position for number: 18 is -> " + main.getFirstSetBit(18));
		System.out.println("First setbit position for number: 5 is -> " + main.getFirstSetBit(5));
		System.out.println("First setbit position for number: 32 is -> " + main.getFirstSetBit(32));
	}
}
