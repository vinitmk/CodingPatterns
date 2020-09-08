package com.mkv.codingpatterns.slidingwindow;

/*
Given a string and a pattern, find out if the string contains any permutation of the pattern.
*/

import java.util.HashMap;
import java.util.Map;

public class StringPermutation {

	private boolean doesPermutationExist(String str, String pattern) {
		int start = 0, count = 0;
		char right, left;
		Map<Character, Integer> patternMap = new HashMap<>();
		for(int i = 0; i < pattern.length(); i++) {
			patternMap.put(pattern.charAt(i), patternMap.getOrDefault(pattern.charAt(i), 0)+1);
		}

		for(int end = 0; end < str.length(); end++) {
			right = str.charAt(end);
			if(patternMap.containsKey(right)) {
				patternMap.put(right, patternMap.get(right)-1);
				if(patternMap.get(right) == 0)
					count++;
			}

			if(count == patternMap.size())
				return true;

			if(end >= pattern.length()-1) {
				left = str.charAt(start++);
				if(patternMap.containsKey(left)) {
					if(patternMap.get(left) == 0)
						count--;
					patternMap.put(left, patternMap.get(left)+1);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		StringPermutation main  = new StringPermutation();

		System.out.println("Permutation exist: " + main.doesPermutationExist("oidbcaf", "abc"));
		System.out.println("Permutation exist: " + main.doesPermutationExist("odicf", "dc"));
		System.out.println("Permutation exist: " + main.doesPermutationExist("bcdxabcdy", "bcdyabcdx"));
		System.out.println("Permutation exist: " + main.doesPermutationExist("aaacb", "abc"));


	}
}
