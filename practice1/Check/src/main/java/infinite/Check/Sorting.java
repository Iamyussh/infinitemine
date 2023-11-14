package infinite.Check;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorting {
    public static void main(String[] args) {
        // Create an Employee class
        class Employee {
            // Fields or instance variables
            private int id;
            private String name;
            private String email;
            private double salary;

            // Constructor
            public Employee(int id, String name, String email, double salary) {
                this.id = id;
                this.name = name;
                this.email = email;
                this.salary = salary;
            }

            // Getter and setter methods for the fields
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

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public double getSalary() {
                return salary;
            }

            public void setSalary(double salary) {
                this.salary = salary;
            }

            // Method to calculate the annual salary
            public double calculateAnnualSalary() {
                return salary * 12;
            }

            // Method to display employee information
            public void displayEmployeeInfo() {
                System.out.println("Employee ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
                System.out.println("Salary: $" + salary);
                System.out.println("Annual Salary: $" + calculateAnnualSalary());
            }
        }

        // Create an ArrayList to hold Employee objects
        ArrayList<Employee> employeeList = new ArrayList<>();

        // Add Employee objects to the ArrayList
        employeeList.add(new Employee(101, "John Doe", "john@example.com", 60000.0));
        employeeList.add(new Employee(102, "Jane Smith", "jane@example.com", 55000.0));
        employeeList.add(new Employee(103, "Alice Johnson", "alice@example.com", 62000.0));

        // Sort the ArrayList by employee name using a custom comparator
        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                // Compare based on the names (case-insensitive)
                return emp1.getName().compareTo(emp2.getName());
            }
        });

        // Display the sorted list of employees
        for (Employee employee : employeeList) {
            
            System.out.println(employee);
        }
    }
}

