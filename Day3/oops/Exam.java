package com.java.oops;

public class Exam {
			public static void main(String[] args){
				Student student1 = new Student();
				student1.setId(1);
				student1.setName("Abhishek Mukherjee");
				
				
				GoogleForum forum = new GoogleForum();
				forum.setName(student1.getName());
				forum.mcqTest(student1.getName());
				forum.questions();
				
				
				Hackathon hackathon = new Hackathon();
				hackathon.setLanguage(student1.getName());
				hackathon.setLimit();
			}
			
			
}
