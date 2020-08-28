package com.mkv.codingpatterns.slidingwindow;

/*
Given an array of characters where each character represents a fruit tree,
you are given two baskets and your goal is to put maximum number of fruits in each basket.
The only restriction is that each basket can have only one type of fruit.
*/

import java.util.HashMap;
import java.util.Map;

public class FruitsInBasket {

	private int putFruitInBasket(char[] array) {
		int c, start = 0, maxLength = Integer.MIN_VALUE;
		int index1 = 0, index2 = 0;
		Map<Character, Integer> map = new HashMap<>();
		for(int end = 0; end < array.length; end++) {
			c = map.getOrDefault(array[end], 0);
			c++;
			map.put(array[end], c);
			while(map.size() > 2) {
				c = map.getOrDefault(array[start], 0);
				c--;
				if(c == 0)
					map.remove(array[start]);
				else
					map.put(array[start], c);
				start++;
			}
			if(maxLength < end-start+1) {
				maxLength = end-start+1;
				index1 = start;
				index2 = end;
			}
		}
		System.out.println("Substring is ");
		for(int i = index1; i <= index2; i++)
			System.out.print(array[i] +" ");
		return maxLength;
	}

	public static void main(String[] args) {
		FruitsInBasket main = new FruitsInBasket();

		System.out.println(main.putFruitInBasket(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
		System.out.println(main.putFruitInBasket(new char[]{'A', 'B', 'C', 'A', 'C'}));
	}
}
