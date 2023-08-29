package ccom.java.day4;

public class Employ {
		private int empmo;
		private String name;
		private double basic;
		
		
		
		@Override
		public String toString() {
			return "Employ [empmo=" + empmo + ", name=" + name + ", basic="
					+ basic + "]";
		}
		
		
		
		public Employ(int empmo, String name, double basic) {
			super();
			this.empmo = empmo;
			this.name = name;
			this.basic = basic;
		}
		
		
		public Employ() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public int getEmpmo() {
			return empmo;
		}
		public void setEmpmo(int empmo) {
			this.empmo = empmo;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getBasic() {
			return basic;
		}
		public void setBasic(double basic) {
			this.basic = basic;
		}
		
		
}
