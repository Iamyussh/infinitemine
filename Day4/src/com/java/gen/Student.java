package com.java.gen;

public class Student {
		private int id;
		private String name;
		private String city;
		private double cgpa;
		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + ", city=" + city
					+ ", cgpa=" + cgpa + "]";
		}
		public Student(int id, String name, String city, double cgpa) {
			super();
			this.id = id;
			this.name = name;
			this.city = city;
			this.cgpa = cgpa;
		}
		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
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
