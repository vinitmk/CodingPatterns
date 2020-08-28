package com.mkv.codingpatterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubString {

	private int findNoRepeatSubString(String word) {
		int end, maxLength = Integer.MIN_VALUE, start = 0;
		StringBuilder sb = new StringBuilder();
		Map<Character, Integer> map = new HashMap<>();
		for(end = 0; end < word.length(); end++) {
			if(map.containsKey(word.charAt(end))) {
				maxLength = Math.max(maxLength, end-start);
				start = end;
				map.clear();
			}
			map.put(word.charAt(end), 1);
		}
		maxLength = Math.max(maxLength, end-start);
		return maxLength;
	}

	public static void main(String[] args) {
		NoRepeatSubString main = new NoRepeatSubString();

		System.out.println("Longest substring is  "+ main.findNoRepeatSubString("aabccbb"));
		System.out.println("Longest substring is  "+ main.findNoRepeatSubString("abbbb"));
		System.out.println("Longest substring is  "+ main.findNoRepeatSubString("abccdef"));
	}
}
