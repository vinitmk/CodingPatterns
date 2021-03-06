package com.mkv.codingpatterns.bitmanipulation;

public class FirstSetBitPosition {

	private int getFirstSetBitUsingLeftShift(int n) {
		int k = 1;
		while(true) {
			if((n & (1 << k-1)) == 0)
				k++;
			else
				return k;
		}
	}

	private int getFirstSetBitUsingRightShift(int n) {
		int k = 1;
		if(n == 0)
			return 0;

		while(true) {

			if(((n >> k-1) & 1) == 1)
				return k;
			else
				k++;

		}

	}

	public static void main(String[] args) {

		FirstSetBitPosition main = new FirstSetBitPosition();

		System.out.println("First setbit position for number: 18 is -> " + main.getFirstSetBitUsingLeftShift(18));
		System.out.println("First setbit position for number: 5 is -> " + main.getFirstSetBitUsingLeftShift(5));
		System.out.println("First setbit position for number: 32 is -> " + main.getFirstSetBitUsingLeftShift(32));

		System.out.println("First setbit position for number: 18 is -> " + main.getFirstSetBitUsingRightShift(18));
		System.out.println("First setbit position for number: 5 is -> " + main.getFirstSetBitUsingRightShift(5));
		System.out.println("First setbit position for number: 32 is -> " + main.getFirstSetBitUsingRightShift(32));
	}
}
