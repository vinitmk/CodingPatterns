package com.mkv.codingpatterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
Given a string with lowercase letters only,
if you are allowed to replace no more than ‘k’ letters with any letter,
find the length of the longest substring having the same letters after replacement.
*/

public class CharacterReplacement {

	private int findMaxSubStringAfterReplacement(String word, int k) {
		char c, c1;
		int start = 0, end, maxLength = 0, maxRepeatLetterCount = 0;
		Map<Character, Integer> map = new HashMap<>();
		for(end = 0; end < word.length(); end++) {
			c = word.charAt(end);
			map.put(c, map.getOrDefault(c, 0)+1);
			maxRepeatLetterCount = Math.max(maxRepeatLetterCount, map.get(c));
			if(end - start + 1 - maxRepeatLetterCount > k) {
				c1 = word.charAt(start);
				map.put(c1, map.get(c1)-1);
				start++;
			}
			maxLength = Math.max(maxLength, end - start + 1);
		}
		return maxLength;
	}

	public static void main(String[] args) {
		CharacterReplacement main = new CharacterReplacement();

		System.out.println(main.findMaxSubStringAfterReplacement("aabccbb", 2));
		System.out.println(main.findMaxSubStringAfterReplacement("abbcb", 1));
		System.out.println(main.findMaxSubStringAfterReplacement("abccde", 1));
	}
}
