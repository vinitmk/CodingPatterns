package com.mkv.codingpatterns.slidingwindow;

/* Given a string, find the length of the longest substring in it with no more than K distinct characters.
*/

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {

	private int findLongestSubstring(String word, int k) {
		int c, start = 0, maxLength = 0;
		Map<Character, Integer> map = new HashMap<>();
		for(int end = 0; end < word.length(); end++) {
			c = map.getOrDefault(word.charAt(end), 0);
			c++;
			map.put(word.charAt(end), c);
			while(map.size() > k) {
				c = map.get(word.charAt(start));
				c--;
				if(c == 0)
					map.remove(word.charAt(start));
				else
					map.put(word.charAt(start), c);
				start++;
			}
			maxLength = Math.max(maxLength, end-start+1);
		}
		return maxLength;
	}

	public static void main(String[] args) {
		LongestSubstringKDistinct main = new LongestSubstringKDistinct();

		System.out.println("Length of the longest substring: " + main.findLongestSubstring("araaci", 2));
		System.out.println("Length of the longest substring: " + main.findLongestSubstring("araaci", 1));
		System.out.println("Length of the longest substring: " + main.findLongestSubstring("cbbebi", 3));

	}
}
