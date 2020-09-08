package com.mkv.codingpatterns.slidingwindow;

/*Given a string and a pattern, find all anagrams of the pattern in the given string.*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagrams {

	private List<Integer> getAnagrams(String str, String pattern) {
		int start = 0, count = 0;
		char right, left;
		Map<Character, Integer> patternMap = new HashMap<>();
		for(int i = 0; i < pattern.length(); i++) {
			patternMap.put(pattern.charAt(i), patternMap.getOrDefault(pattern.charAt(i), 0)+1);
		}
		List<Integer> anagramList = new ArrayList<>();
		for(int end = 0; end < str.length(); end++) {
			right = str.charAt(end);
			if(patternMap.containsKey(right)) {
				patternMap.put(right, patternMap.get(right)-1);
				if(patternMap.get(right) == 0)
					count++;
			}
			if(count == patternMap.size())
				anagramList.add(start);

			if(end >= pattern.length()-1) {
				left = str.charAt(start++);
				if(patternMap.containsKey(left)) {
					if(patternMap.get(left) == 0)
						count--;
					patternMap.put(left, patternMap.get(left)+1);
				}
			}
		}
		return anagramList;
	}

	public static void main(String[] args) {
		StringAnagrams main = new StringAnagrams();

		System.out.println(main.getAnagrams("ppqp", "pq"));
		System.out.println(main.getAnagrams("abbcabc", "abc"));
	}
}
