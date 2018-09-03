package com.gmail.s.granovskiy;

public class Student extends Human {
	
	private boolean isExamPassed;
	private boolean isScholarshipReceived;
	
	/*  constructors  */
	public Student(int id, String firstName, String lastName, int age, boolean sex, boolean isExamPassed,
			boolean isScholarshipReceived) {
		super(id, firstName, lastName, age, sex);
		this.isExamPassed = isExamPassed;
		this.isScholarshipReceived = isScholarshipReceived;
	}
	public Student() {
		super();
	}

	/*  getters and setters  */
	public boolean isExamPassed() {
		return isExamPassed;
	}
	public void setExamPassed(boolean isExamPassed) {
		this.isExamPassed = isExamPassed;
	}
	public boolean isScholarshipReceived() {
		return isScholarshipReceived;
	}
	public void setScholarshipReceived(boolean isScholarshipReceived) {
		this.isScholarshipReceived = isScholarshipReceived;
	}	

	@Override
	public String toString() {
		return "Student [isExamPassed=" + isExamPassed + ", isScholarshipReceived=" + isScholarshipReceived + ", " + super.toString();
	}
	
}
