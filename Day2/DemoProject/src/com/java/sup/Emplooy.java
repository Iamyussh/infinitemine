package com.java.sup;

public class Emplooy {
		int empno;
		String name;
		double basic;
		@Override
		public String toString() {
			return "Emplooy [empno=" + empno + ", name=" + name + ", basic="
					+ basic + "]";
		}
		
		
		public Emplooy(int empno, String name, double basic) {
			super();
			this.empno = empno;
			this.name = name;
			this.basic = basic;
		}
		
		
		
		
}
