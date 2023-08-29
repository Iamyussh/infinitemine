package ccom.java.day4;

public class Student {
	private int studentId;
	private String name;
	private String city;
	private double cgpa;
	
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", city="
				+ city + ", cgpa=" + cgpa + "]";
	}


	public Student(int studentId, String name, String city, double cgpa) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.city = city;
		this.cgpa = cgpa;
	}


	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public double getCgpa() {
		return cgpa;
	}


	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	
	
	
	

}
