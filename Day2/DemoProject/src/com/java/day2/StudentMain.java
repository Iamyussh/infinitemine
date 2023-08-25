package com.java.day2;

public class StudentMain {
			public static void main(String[] args){
				Student student = new Student();
				student.studentId =1;
				student.name = "Obama";
				student.course = Course.JAVA;
				student.cgpa = 8.9;
				
				
				System.out.println("Student Id = " + student.studentId);
				System.out.println("Student Name = " + student.name);
				System.out.println("Course = " + student.course);
				System.out.println("CGPA = " + student.cgpa);
				
			}
}
