package org.java8.streams.basics;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		
		String[]array = {"Tom", "Soban", "Mohit"};
		
		Stream<String> stringStream = Stream.of(array);
		
		stringStream.map(e -> e.toUpperCase())
			.forEach(e -> System.out.println(e));
		System.out.println("-------------------------------------------------------------");
		Student student1 = new Student("Soban", 25, new Address("111111"),
				Arrays.asList(new MobileNumber("1111111111"), new MobileNumber("2222222222")));
		Student student2 = new Student("Mohit", 25, new Address("222222"),
				Arrays.asList(new MobileNumber("3333333333"), new MobileNumber("4444444444")));
		Student student3 = new Student("Ravi", 25, new Address("333333"),
				Arrays.asList(new MobileNumber("4444444444"), new MobileNumber("6666666666")));

		List<Student> listStudents = Arrays.asList(student1, student2, student3);

		/*****************************************************
		 * Get student with exact match name "Soban"
		 *****************************************************/
		Optional<Student> stud1 = listStudents.stream().filter(s -> s.getName().equals("Soban")).findFirst();
		System.out.println(stud1.isPresent() ? stud1.get().getName() : "No Student found with name Soban");
		System.out.println("----------------------------------------------------------------");
		/*****************************************************
		 * Get student with matching address "222222"
		 *****************************************************/
		Optional<Student> stud2 = listStudents.stream().filter(s -> s.getAddress().getZipcode().equals("222222"))
				.findFirst();
		System.out.println(stud2.isPresent() ? "student with zipcode 222222 is : " + stud2.get().getName()
				: "no student found with address 222222");
		System.out.println("-----------------------------------------------------------------");
		/*****************************************************
		 * Get all student having mobile numbers 33333333333.
		 *****************************************************/

		List<Student> list = listStudents.stream()
				.filter(s -> s.getMobileNumbers().stream().anyMatch(x -> Objects.equals(x.getNumber(), "3333333333")))
				.collect(Collectors.toList());
		list.forEach(s -> System.out.println(s.getName()));
		System.out.println("------------------------------------------------------------------");
		/*****************************************************
		 * Get all student having mobile number 3333333333 and 4444444444
		 *****************************************************/
		List<Student> list2 = listStudents.stream().filter(s -> s.getMobileNumbers().stream().allMatch(
				x -> Objects.equals(x.getNumber(), "3333333333") || Objects.equals(x.getNumber(), "4444444444")))
				.collect(Collectors.toList());
		list2.forEach(s -> System.out.println(s.getName()));
		System.out.println("------------------------------------------------------------------");

		/*****************************************************
		 * Create a List<Student> from the List<TempStudent>
		 *****************************************************/

		TempStudent tmpStud1 = new TempStudent("Jayesh1", 201, new Address("12341"),
				Arrays.asList(new MobileNumber("12331"), new MobileNumber("12341")));

		TempStudent tmpStud2 = new TempStudent("Khyati1", 202, new Address("12351"),
				Arrays.asList(new MobileNumber("11111"), new MobileNumber("33331"), new MobileNumber("12331")));

		List<TempStudent> tmpStudents = Arrays.asList(tmpStud1, tmpStud2);

		List<Student> myStudents = tmpStudents.stream()
				.map(tmpS -> new Student(tmpS.name, tmpS.age, tmpS.address, tmpS.mobileNumbers))
				.collect(Collectors.toList());
		System.out.println(myStudents);
		System.out.println("------------------------------------------------------------------");

		/*****************************************************
		 * Convert List<Student> to List<String> of student name
		 *****************************************************/

		List<String> studentNames = listStudents.stream()
				.map(st -> st.getName())
				.collect(Collectors.toList());
		System.out.println(studentNames);
		System.out.println("------------------------------------------------------------------");

		/*****************************************************
		 * Convert List<students> to String
		 *****************************************************/

		String names = listStudents.stream()
				.map(s -> s.getName())
				.collect(Collectors.joining(", ", "[", "]"));
		System.out.println(names);
		System.out.println("------------------------------------------------------------------");
		
		/*****************************************************
		 * Change the case of List<String>
		 *****************************************************/
		List<String> listNames = Arrays.asList("Soban", "Arun", "Ravi", "Mohit");
		listNames.stream()
        	.map(String::toUpperCase)
        	.forEach(System.out::println);
		System.out.println("------------------------------------------------------------------");

		/*****************************************************
		 * Sort List<String>
		 *****************************************************/
		listNames.stream()
			.sorted()
			.forEach(System.out::println);
		System.out.println("------------------------------------------------------------------");

		/*****************************************************
		 * Conditionally apply Filter condition, say if flag is enabled then
		 *****************************************************/
	}

}
