package org.java8.streams.MapAndCollect;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMap {

	public static void main(String[] args) {
		
		String[][] myString = {{"ab","cd"},{"ef","gf"},{"ij","kl"}};
		Stream<String[]> firstStream = Stream.of(myString);

		Stream<String> secondStream =  firstStream.flatMap(x -> Arrays.stream(x));
		
		secondStream.forEach(System.out::println);
	}
	
}
