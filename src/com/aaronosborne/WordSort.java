package com.aaronosborne;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class WordSort {

	public static void main(String[] args) {
		List<String> words = new ArrayList<>();
		words.add("AAAC");
		words.add("AbAB");
		words.add("AAAA");
//		words.add("AAA4");//send bad data test
		Collections.sort(words, new WordComparator());
		for (String word : words) {
			System.out.println(word);
		}
	}

}

class WordComparator implements Comparator<String> {
	private static final Map<Character, Integer> charNumberMap = createCharNumberMap();
	
	private static Map<Character, Integer> createCharNumberMap() {
        Map<Character, Integer> map = new HashMap<>(26);
        char currentChar = 'A';
        int currentNumber = 1;
        for (int i = 0; i < 26; ++i) {
            map.put(currentChar, currentNumber);
            ++currentChar;
            ++currentNumber;
        }
        return map;
    }

	@Override
	public int compare(String word1, String word2) {
		int value1 = calculateWordValue(word1);
		int value2 = calculateWordValue(word2);
		return Integer.compare(value1, value2);
	}

	int calculateWordValue(String word) {

		int value = 0;
		word = word.toUpperCase();
		
		if(!word.matches("[A-Z]+")) {
			throw new IllegalArgumentException("Invalid word: " + word);
		}
		for (char letter : word.toCharArray()) {
			value += charNumberMap.get(letter);
		}
		return value;
	}
}