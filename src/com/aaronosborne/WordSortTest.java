package com.aaronosborne;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordSortTest {

    @Test
    public void testSortWords() {
        List<String> words = new ArrayList<>();
        words.add("AAAC");//second
		words.add("AbAB");//third
		words.add("AAAA");//should be first
//		words.add("AAA4");//send bad data test
        
        List<String> expected = new ArrayList<>();
        expected.add("AAAA");
        expected.add("AAAC");
        expected.add("AbAB");
        
        List<String> sortedWords = new ArrayList<>(words);
        Collections.sort(sortedWords, new WordComparator());

        assertEquals(expected, sortedWords);
    }

    @Test
    public void testCalculateWordValue() {
        WordComparator comparator = new WordComparator();

        assertEquals(1, comparator.calculateWordValue("A"));
        assertEquals(3, comparator.calculateWordValue("C"));
        assertEquals(2, comparator.calculateWordValue("AA"));
        assertEquals(5, comparator.calculateWordValue("AAAB"));
    }
}