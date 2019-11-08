package org.java8.streams.GroupByAndPartitionBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.java8.streams.retrievingObjectFromStream.Person;

public class GroupBy {

public static void main(String[] args) {
		
		List<Person> listOfPeople = Arrays.asList(new Person(32, "Soban", "0"), new Person(26, "Soban", "1"),
				new Person(26, "Pooja", "1"), new Person(32, "Hina", "0"), new Person(100, "yumraaj", "0"),
				new Person(72, "gandhi", "1"), new Person(18, "kiran", "0"));

		
		Map<Boolean, List<Person>> collect = listOfPeople.stream()
				.collect(Collectors.groupingBy(p -> p.getStatus().equals("0")));
		
		collect.entrySet().stream().forEach((Entry<Boolean, List<Person>> t) -> System.out
				.println("Key is " + t.getKey() + " and value is " + t.getValue()));
		
		// if i have to grou p by age then i can go for
		System.out.println("-------------------------------------------------------");
		// for counting Collcetors has a method count
		System.out.println(
				listOfPeople.stream()
				.collect(Collectors.groupingBy(p -> p.getAge(), Collectors.counting()))
				);		
		
		
		listOfPeople.stream().collect(Collectors.groupingBy(person -> person.getAge())).entrySet().stream()
		.forEach( en -> System.out.println(en));
	}
}
