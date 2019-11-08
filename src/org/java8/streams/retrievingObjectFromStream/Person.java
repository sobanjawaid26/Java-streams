package org.java8.streams.retrievingObjectFromStream;

public class Person {
	
	private int age;
	private String name ;
	private String status;
	
	
	
	public Person(int age, String name, String status) {
		super();
		this.age = age;
		this.name = name;
		this.status = status;
	}


	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", status=" + status + "]";
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
