package com.gmail.s.granovskiy;

import java.util.Scanner;
import com.gmail.s.granovskiy.MyException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Group implements Voenkom {

	/* making a list */
	private List<Student> studentsArray = new ArrayList<Student>();
	private int counter;

	/* constructors */
	public Group(List<Student> studentsArray) {
		super();
		this.studentsArray = studentsArray;
	}

	public Group() {
		super();
	}

	/* getters and setters */
	public List<Student> getStudentsArray() {
		return studentsArray;
	}
	public void setStudentsArray(List<Student> studentsArray) {
		this.studentsArray = studentsArray;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}

	/* method addStudent */
	public void addStudent(Student student) throws MyException {

		if (studentsArray.size() < 13) {
			studentsArray.add(student);
		} else {
			throw new MyException();
		}
	}

	/* method deleteStudent */
	public void deleteStudent(int index) {
		studentsArray.set((index - 1), null);
	}

	/* method searchStudent */
	public Student searchStudent(String searchedLastName) {
		for (Student student : studentsArray) {
			if (student != null && student.getLastName().equals(searchedLastName)) {
				return student;
			}
		}
		return null;
	}

	/* methods to read info about student from scanner */
	public int getStudentId() {
		System.out.println("Please, enter student's ID.");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	public String getStudentFirstName() {
		System.out.println("Please, enter student's first name.");
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}

	public String getStudentLastName() {
		System.out.println("Please, enter student's last name.");
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}

	public int getStudentAge() {
		System.out.println("Please, enter student's age.");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	public boolean getStudentSex() {
		System.out.println("Please, enter student's sex.");
		Scanner sc = new Scanner(System.in);
		return sc.nextBoolean();
	}

	public boolean getStudentExamPassed() {
		System.out.println("Please, enter if the student has passed the exams: true or false");
		Scanner sc = new Scanner(System.in);
		return sc.nextBoolean();
	}

	public boolean getScholarshipReceived() {
		System.out.println("Please, enter if the student is getting the scolarship: true or false");
		Scanner sc = new Scanner(System.in);
		return sc.nextBoolean();
	}

	/* method to make student from scanned info */
	public Student makeStudent() {
		Student student = new Student(getStudentId(), getStudentFirstName(), getStudentLastName(), getStudentAge(),
				getStudentSex(), getStudentExamPassed(), getScholarshipReceived());
		return student;
	}

	/*  method to get scanned info and create a student object and add it to the group  */
	public void getStudentInfoAndAdd() {
		/* Starting dialog with a user */
		System.out.println();
		System.out.print("Do you want to enter more student data? Please, type: Y/N.");

		/* scanner work */
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		System.out.println();

		/* conditional statement */
		if (word.equals("Y")) {
			try {
				/* making and adding student to group */
				System.out.print("OK! Let's get started! ");
				this.addStudent(this.makeStudent());

			} catch (MyException e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Well... Maybe next time...  :).  Good-bye! ");
		}
	}

	public int countNulls() {
		counter = 0;
		Iterator<Student> itr = studentsArray.iterator();
		for (; itr.hasNext();) {
			Student element = itr.next();
			if (element == null) {
				counter++;
			}
		}
		return counter;
	}

	public void loopStudentInfoAndAdd() {
		final int k = this.countNulls();
		for (int i = 0; i <= k; i++) {
			this.getStudentInfoAndAdd();
			// System.out.println(this);
		}
	}

	/* method for sorting students by last name */
	public void sortLastName() {
		for (int i = 0; i < studentsArray.size() - 1; i++) {
			for (int j = i + 1; j < studentsArray.size(); j++) {
				if (compareStudentLastName(studentsArray.get(i), studentsArray.get(j)) > 0) {
					Student temp = studentsArray.get(i);
					studentsArray.set(i, studentsArray.get(j));
					studentsArray.set(j, temp);
				}
			}
		}
	}

	/* method to compare 2 family names */
	private int compareStudentLastName(Student a, Student b) {
		if (a != null && b == null) {
			return 1;
		}
		if (a == null && b != null) {
			return -1;
		}
		if (a == null && b == null) {
			return 0;
		}
		return a.getLastName().compareTo(b.getLastName());
	}

	@Override
	/*   method readyForArmy() returns array voenkomArray of students ready for the Army  */
	public List<Student> readyForArmy() {

		/* then the method creates, fills and returns voenkomArray */
		List<Student> voenkomArray = new ArrayList<Student>();

		try (PrintWriter pw = new PrintWriter("c.csv")) {
			//int i = 0;
			for (Student student : this.studentsArray) {
				if (student != null && student.isSex() == true && student.getAge() >= 18) {
					voenkomArray.add(student);
					//i++;
					pw.println(student);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR FILE WRITE");
		}
		return voenkomArray;
	}

	// toString method   
	@Override
	public String toString() {
		return "Group [studentsArray=" + Arrays.toString(studentsArray.toArray()) + "]";
	}
}
