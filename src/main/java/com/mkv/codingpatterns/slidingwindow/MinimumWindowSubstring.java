package com.mkv.codingpatterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {


	private String findSubString(String str, String pattern) {
/*
		int start = 0, match = 0, minLength = 0, subStringStart = 0;
		char rightChar, leftChar;
		Map<Character, Integer> patternMap = new HashMap<>();
		for(char c: str.toCharArray())
			patternMap.put(c, patternMap.getOrDefault(c, 0)+1);

		for(int end = 0; end < str.length(); end++) {
			rightChar = str.charAt(end);
			if(patternMap.containsKey(rightChar)) {
				patternMap.put(rightChar, patternMap.get(rightChar)-1);
				if(patternMap.get(rightChar) >= 0)
					match++;
			}

			while(match == pattern.length()) {
				if(minLength > end - start + 1) {
					minLength = end - start + 1;
					subStringStart = start;
				}

				leftChar = str.charAt(start++);
				if(patternMap.containsKey(leftChar)) {
					if(patternMap.get(leftChar) == 0)
						match--;
					patternMap.put(leftChar, patternMap.get(leftChar) + 1);
				}
			}
		}
		return minLength > str.length() ? "" : str.substring(subStringStart, subStringStart + minLength);
*/
		int windowStart = 0, matched = 0, minLength = str.length() + 1, subStrStart = 0;
		Map<Character, Integer> charFrequencyMap = new HashMap<>();
		for (char chr : pattern.toCharArray())
			charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

		// try to extend the range [windowStart, windowEnd]
		for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			char rightChar = str.charAt(windowEnd);
			if (charFrequencyMap.containsKey(rightChar)) {
				charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
				if (charFrequencyMap.get(rightChar) >= 0) // count every matching of a character
					matched++;
			}

			// shrink the window if we can, finish as soon as we remove a matched character
			while (matched == pattern.length()) {
				if (minLength > windowEnd - windowStart + 1) {
					minLength = windowEnd - windowStart + 1;
					subStrStart = windowStart;
				}

				char leftChar = str.charAt(windowStart++);
				if (charFrequencyMap.containsKey(leftChar)) {
					// note that we could have redundant matching characters, therefore we'll decrement the
					// matched count only when a useful occurrence of a matched character is going out of the window
					if (charFrequencyMap.get(leftChar) == 0)
						matched--;
					charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
				}
			}
		}

		return minLength > str.length() ? "" : str.substring(subStrStart, subStrStart + minLength);
	}

	public static void main(String[] args) {
		MinimumWindowSubstring main = new MinimumWindowSubstring();

		System.out.println(main.findSubString("aabdec", "abc"));
		System.out.println(main.findSubString("abdabca", "abc"));
		System.out.println(main.findSubString("adcad", "abc"));
	}
}
