package com.mkv.codingpatterns.fastandslowpointers;

/*
Any number will be called a happy number if, after repeatedly replacing it
with a number equal to the sum of the square of all of its digits,
leads us to number ‘1’. All other (not-happy) numbers will never reach ‘1’.
Instead, they will be stuck in a cycle of numbers which does not include ‘1’.

Time Complexity #
The time complexity of the algorithm is difficult to determine. However we know the fact that all unhappy numbers eventually get stuck in the cycle:
4 -> 16 -> 37 -> 58 -> 89 -> 145 -> 42 -> 20 -> 4

This sequence behavior tells us two things:

If the number NN is less than or equal to 1000, then we reach the cycle or ‘1’ in at most 1001 steps.
For N > 1000N>1000, suppose the number has ‘M’ digits and the next number is ‘N1’. From the above Wikipedia link, we know that the sum of the squares of the digits of ‘N’ is at most 9^2M9
​2
​​ M, or 81M81M (this will happen when all digits of ‘N’ are ‘9’).
This means:

N1 < 81M
As we know M = log(N+1)
Therefore: N1 < 81 * log(N+1) => N1 = O(logN)
This concludes that the above algorithm will have a time complexity of O(logN).

Space Complexity #
The algorithm runs in constant space O(1).
*/

public class HappyNumber {

	public boolean find(int num) {
		int slow = num, fast = num;
		do{
			slow = findSquareSum(slow);
			fast = findSquareSum(findSquareSum(fast));

		} while (slow != fast);

		return slow == 1;
	}

	private int findSquareSum(int n) {
		int sumOfSquare = 0, r;
		while(n != 0) {
			r = n % 10;
			sumOfSquare += (r*r);
			n /= 10;
		}
		return sumOfSquare;
	}

	public static void main(String[] args) {

		HappyNumber main = new HappyNumber();

		System.out.println(main.find(23));
		System.out.println(main.find(12));
	}
}
