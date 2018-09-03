package com.gmail.s.granovskiy;

public class Human {
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private boolean sex;
	
	/*  constructors  */
	public Human(int id, String firstName, String lastName, int age, boolean sex) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.sex = sex;
	}
	public Human() {
		super();
	}

	/*  getters and setters  */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	
	//  toString
	@Override
	public String toString() {
		return "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", sex=" + sex + "]";    
	}	
}
