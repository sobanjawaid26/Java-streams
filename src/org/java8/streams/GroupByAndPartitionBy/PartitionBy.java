package org.java8.streams.GroupByAndPartitionBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map.Entry;

import org.java8.streams.retrievingObjectFromStream.Person;

public class PartitionBy {

	public static void main(String[] args) {
		List<Person> listOfPeople = Arrays.asList(new Person(32, "Kartik", "0"), new Person(26, "Kshitij", "1"),
				new Person(26, "Pooja", "1"), new Person(32, "Hina", "0"), new Person(100, "yumraaj", "0"),
				new Person(72, "gandhi", "1"), new Person(26, "kiran", "0"));

		listOfPeople.stream().collect(Collectors.partitioningBy(person -> person.getStatus().equals("1"))).entrySet()
				.stream().forEach((Entry<Boolean, List<Person>> t) -> System.out
						.println("Key is " + t.getKey() + " and value is " + t.getValue()));

		System.out.println("-------------------------------------------------------");
		// for counting Collcetors has a method count
		System.out.println(listOfPeople.stream()
				.collect(Collectors.partitioningBy(person -> person.getStatus().equals("1"), Collectors.counting())));
		
		// if i have to grou p by age then i can go for
		System.out.println("-------------------------------------------------------");
		// for counting Collcetors has a method count
		System.out.println(listOfPeople.stream()
				.collect(Collectors.partitioningBy(person -> person.getStatus().equals("0"), Collectors.counting())));
		
	}
	
}
