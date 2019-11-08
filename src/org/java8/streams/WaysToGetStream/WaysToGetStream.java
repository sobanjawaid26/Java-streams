package org.java8.streams.WaysToGetStream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class WaysToGetStream {

	public static void main(String[] args) {
		
		
		
		// 1
		System.out.println("Obtain stream from a list");
		Stream<String> stream1 = Arrays.asList("a", "b", "c", "d", "e").stream();
		stream1.forEach(System.out::println);
		System.out.println("-----------------------------------------------------------");

		// 2
		System.out.println("Obtain stream from map");
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "x");
		map.put(2, "y");
		map.put(3, "z");
		map.entrySet().stream().forEach(System.out::println);
		System.out.println("-----------------------------------------------------------");

		// 3
		System.out.println("From a String using chars() method");
		"Kshitij Joshi".chars().forEach(ch -> System.out.println((char) ch));
		System.out.println("-----------------------------------------------------------");

		// 4
		System.out.println("From a String using split() method");
		Stream.of("Pooja Joshi".split(" ")).forEach(ch -> System.out.println(ch));
		System.out.println("-----------------------------------------------------------");

		// 5
		System.out.println("From a Array using Stream.of(new array[])");
		// will work for object type array
		Stream.of(new Integer[] { 1, 2, 3, 4, 1, 2, 3, 4 }).forEach(i -> System.out.println(i));
		System.out.println("-----------------------------------------------------------");

		// 6
		System.out.println("From stream.of()");
		Stream.of(11, 12, 13, 14, 15).forEach(x -> System.out.println(x));
		System.out.println("-----------------------------------------------------------");

		// 7
		System.out.println("from generate method in stream");
		Stream.generate(() -> new Random().nextInt()).limit(10).forEach(x -> System.out.println(x));
		System.out.println("-----------------------------------------------------------");

		// 8
		System.out.println("from iterate method in stream");
		Stream.iterate(10, i -> i + 1).limit(12).forEach(x -> System.out.println(x));
		System.out.println("-----------------------------------------------------------");

		// 9
		System.out.println("from builder method in stream");
		Stream.builder().add("raju").add("asde").add("q123").build().forEach(x -> System.out.println(x));
		System.out.println("-----------------------------------------------------------");

	}

}
