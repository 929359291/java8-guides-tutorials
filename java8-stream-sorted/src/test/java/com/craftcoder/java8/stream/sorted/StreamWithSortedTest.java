package com.craftcoder.java8.stream.sorted;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class StreamWithSortedTest {

	@Test
	public void shouldSortTheList() throws Exception {
		List<String> listOfWords = Arrays.asList("B", "A", "D", "E", "C");
		
		List<String> sortedList = listOfWords
			.stream()
			.sorted()
			.collect(Collectors.toList());
		
		assertThat(sortedList, contains("A", "B", "C", "D", "E"));
	}
	
	@Test
	public void shouldSortTheListWithInvertedComparator() throws Exception {
		List<String> listOfWords = Arrays.asList("B", "A", "D", "E", "C");
		
		Comparator<String> inverted = (String o1, String o2) -> o2.compareTo(o1);
		
		List<String> sortedList = listOfWords
				.stream()
				.sorted(inverted)
				.collect(Collectors.toList());
		
		assertThat(sortedList, contains("E", "D", "C", "B", "A"));
	}
	
}
