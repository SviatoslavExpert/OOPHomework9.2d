package com.gmail.s.granovskiy;

import com.gmail.s.granovskiy.MyException;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// creating group object
		Group group = new Group();
			
		/*  creating 11 objects of Student class using constructor  */ 
		Student student1 = new Student(001, "Mike", "Tomson", 22, true, true, true);
		Student student2 = new Student(002, "Tina", "Dobson", 21, false, false, false);
		Student student3 = new Student(003, "Lina", "Sheer", 22, false, false, false);
		Student student4 = new Student(004, "Luka", "Beer", 21, true, false, true);
		Student student5 = new Student(005, "Bob", "Lobster", 21, true, false, true);
		Student student6 = new Student(006, "Tom", "Taheer", 21, true, true, true);
		Student student7 = new Student(007, "Ted", "Liber", 20, true, false, true);
		Student student8 = new Student(010, "Rick", "Trauben", 20, true, false, true);
		Student student9 = new Student(011, "Rob", "Tratilaus", 20, true, false, true);
		Student student10 = new Student(012, "Rick", "Macron", 20, true, false, true);
		Student student11 = new Student(013, "Steeve", "Gorilla", 21, true, true, true);
		
		/*  try/catch and work with exception  */
		/*  adding students to the group  */
		try { 
				group.addStudent(student1);
				group.addStudent(student2);
				group.addStudent(student3);
				group.addStudent(student4);
				group.addStudent(student5);
				group.addStudent(student6);
				group.addStudent(student7);
				group.addStudent(student8);
				group.addStudent(student9);
				group.addStudent(student10);
				group.addStudent(student11);
				
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
		
		/*  see the state of the group object after adding 11 student objects */
		System.out.println();
		System.out.println("Here is the original list of 11 students:");
		System.out.println(group);
		
		/*  calling method deleteStudent  */
		group.deleteStudent(5);
		System.out.println();
		
		/*  see the state of the group object after deleting a student */
		System.out.println("Here is the group list after deleting student with ID 005 (Lobster) from the group: ");
		System.out.println(group);
		
		/*  creating new object: studentNew of Student class  */
		Student studentNew = new Student(53, "Mike", "Tyson", 58, true, true, true);
		
		System.out.println();
		System.out.println("The new student with ID 53 is added to the list.  This is his info: ");
		System.out.println(studentNew);
		System.out.println();
		
		/*  adding object studentNew to the group object with try/catch  */
		try { 
			group.addStudent(studentNew);	
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
		
		/*  see the state of the group object after adding new student object: studentNew */
		System.out.println("Here is the list of students after adding object studentNew:");
		System.out.println(group);

		System.out.println();
		
		/*  calling method searchStudent and printing what the method returns  */
		System.out.println("The searched student Dobson is found: " + group.searchStudent("Dobson"));
		
		System.out.println();
		
		/*  calling the method sortLastName() to sort the list by last name   */
		System.out.println("Here is the list of students after sorting by last name:");
		group.sortLastName();
		System.out.println(group);
		
		System.out.println();
		
		/*  method loopStudentInfoAndAdd() that loops another method: getStudentInfoAndAdd()  */
		group.loopStudentInfoAndAdd();
		
		/*  see the state of the group object after adding new student objects */
		System.out.println();
		System.out.println("Here is the updated list of students:");
		group.sortLastName();
		System.out.println(group);
		
		System.out.println();
		System.out.println("These students are going to the Army:");
		group.sortLastName();
		System.out.println(Arrays.toString((group.readyForArmy()).toArray()));  //  !!!!
	}
}
