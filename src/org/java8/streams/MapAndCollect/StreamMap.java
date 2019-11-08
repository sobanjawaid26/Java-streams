package org.java8.streams.MapAndCollect;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.java8.streams.retrievingObjectFromStream.Person;

public class StreamMap {

	class Student {

		int age;
		String name;

		public Student(String name) {
			super();
			this.age = name.length() + 20;
			this.name = name;
		}

		@Override
		public String toString() {
			return "Student [age=" + age + ", name=" + name + "]";
		}

	}
	
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("ram", "sham", "dhram", "veer");
		System.out.println("list is --- > " + list);
		
		System.out.println("Mapping is performed on the list :");
		// the list is not changed in this case we only changed the list temporarily in the stream
		
		List<Student> listOfStudent = list.stream().map(name -> new StreamMap().new Student(name))
		.collect(Collectors.toList());
		
		System.out.println(listOfStudent);
		
		// example for few methods of stream

		int sumAllAgesInLIst = listOfStudent.stream().map(x -> x.age).reduce(0, (a,b) -> a+b);
		System.out.println(sumAllAgesInLIst);
		
		// map can used to convert the person object into String from stream
		List<Person> listOfPeople = Arrays.asList(new Person(32, "Kartik", "0"), new Person(26, "Kshitij", "1"),
				new Person(26, "Pooja", "1"), new Person(32, "Hina", "0"));
		
		
		listOfPeople.stream().filter(p -> p.getStatus().equals("1"))
		.map(person -> "age :" + person.getAge() + " name :" + person.getName())
		.forEach(p -> System.out.println(p));
	}
}
