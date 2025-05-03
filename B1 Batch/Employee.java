import java.util.*;

class Employee1 {
    String name;
    int employeeId;
    double baseSalary;

    public Employee1(String name2, int employeeId2, double baseSalary2) {
            //TODO Auto-generated constructor stub
        }
    
        public void Employee(String name, int employeeId, double baseSalary) {
        this.name = name;
        this.employeeId = employeeId;
        this.baseSalary = baseSalary;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Base Salary: $" + baseSalary);
    }

    public double calculateSalary() {
        return baseSalary;
    }
}

// Subclass: FullTimeEmployee
class FullTimeEmployee extends Employee1 {
    double bonus;

    public FullTimeEmployee(String name, int employeeId, double baseSalary, double bonus) {
        super(name, employeeId, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Bonus: $" + bonus);
        System.out.println("Total Salary: $" + calculateSalary());
    }
}

// Subclass: PartTimeEmployee
class PartTimeEmployee extends Employee1 {
    int hoursWorked;
    double hourlyRate;

    public PartTimeEmployee(String name, int employeeId, double hourlyRate, int hoursWorked, int i) {
        super(name, employeeId, 0); // Set baseSalary to 0 for part-time employees
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate; // Calculate salary based solely on hours worked
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Hourly Rate: $" + hourlyRate);
        System.out.println("Total Salary: $" + calculateSalary());
    }
}


// Main class to test the hierarchy
public class Employee {
    public static void main(String[] args) {
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("Alice", 1001, 50000, 10000);
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee("Bob", 2002, 10000, 120, 15);

        System.out.println("Full-Time Employee Details:");
        fullTimeEmployee.displayDetails();

        System.out.println("\nPart-Time Employee Details:");
        partTimeEmployee.displayDetails();
    }
}