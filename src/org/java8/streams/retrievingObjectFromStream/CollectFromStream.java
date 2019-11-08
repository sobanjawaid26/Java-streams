package org.java8.streams.retrievingObjectFromStream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectFromStream {

	public static void main(String[] args) {

		List<Person> listOfPeople = Arrays.asList(new Person(32, "Soban", "0"), new Person(26, "Soban", "1"),
				new Person(26, "Pooja", "1"), new Person(32, "Hina", "0"), new Person(100, "yumraaj", "0"),
				new Person(72, "gandhi", "1"), new Person(18, "kiran", "0"), new Person(72, "kiran", "1"),
				new Person(22, "Hina", "1"));

		System.out.println("print only the name of the persons");
		List<String> nameList = listOfPeople.stream()
			.map(s -> s.getName()).collect(Collectors.toList());
		nameList.forEach(System.out::println);
		System.out.println("-----------------------------------------------------------");
		
		System.out.println("print only unique name in list");
		Set<String> listOfUniqueNames = listOfPeople.stream()
				.map(s -> s.getName())
				.collect(Collectors.toSet());
		listOfUniqueNames.forEach(System.out::println);
		System.out.println("-----------------------------------------------------------");
		
		System.out.println("get a map of person from list based on age");
		Map<Integer, List<Person>> mapBasedOnAge = listOfPeople.stream()
				.collect(Collectors.groupingBy( person -> person.getAge() , Collectors.toList()));

		mapBasedOnAge.entrySet()
				.stream()
				.forEach(m -> System.out.println(m));
		System.out.println("-----------------------------------------------------------");

		
		System.out.println("get any collection using toColection(lamda expersion)");
		Set<String> anyCollection = listOfPeople.stream()
				.map(s -> s.getName())
				.collect(Collectors.toCollection(() -> new HashSet<>()));
		anyCollection.forEach(System.out::println);
		System.out.println("-----------------------------------------------------------");

	}
}