package com.mkv.codingpatterns.slidingwindow;

/*Given a string and a list of words, find all the starting indices of substrings in the given string
that are a concatenation of all the given words exactly once without any overlapping of words.
It is given that all words are of the same length.

Time Complexity O(N∗M∗Len) where ‘N’ is the number of characters in the given string,
‘M’ is the total number of words, and ‘Len’ is the length of a word.

The space complexity of the algorithm is O(M)O(M) since at most, we will be storing all
the words in the two HashMaps. In the worst case, we also need O(N)O(N) space for the resulting list.
So, the overall space complexity of the algorithm will be O(M+N).O(M+N)
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordConcatenation {

	private List<Integer> findWordConcatenation(String str, String[] words) {
		List<Integer> listIndex = new ArrayList<>();
		Map<String, Integer> wordMap = new HashMap<>();
		Map<String, Integer> wordSeen;
		for (String word: words)
			wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
		String subString;
		int wordLength = words[0].length(), wordCount = words.length, nextWordIndex;
		for(int i = 0; i <= str.length() - wordLength * wordCount; i++) {
			wordSeen = new HashMap<>();
			for(int j = 0; j < wordCount; j++) {
				nextWordIndex = i + j * wordLength;
				subString = str.substring(nextWordIndex, nextWordIndex + wordLength);

				if(!wordMap.containsKey(subString))
					break;
				wordSeen.put(subString, wordSeen.getOrDefault(subString, 0) + 1);

				if(wordSeen.get(subString) > wordMap.getOrDefault(subString, 0))
					break;

				if(j + 1 == wordCount)
					listIndex.add(i);
			}
		}

		return listIndex;
	}

	public static void main(String[] args) {
		WordConcatenation main = new WordConcatenation();

		List<Integer> result = main.findWordConcatenation("catfoxcat", new String[] { "cat", "fox" });
		System.out.println(result);
		result = main.findWordConcatenation("catcatfoxfox", new String[] { "cat", "fox" });
		System.out.println(result);
	}
}
