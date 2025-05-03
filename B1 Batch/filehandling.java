import java.io.*;
import java.util.*;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void setId(int id) { this.id = id; }
    public int getId() { return id; }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    public void setDepartment(String department) { this.department = department; }
    public String getDepartment() { return department; }

    public void setSalary(double salary) { this.salary = salary; }
    public double getSalary() { return salary; }

    public String toString() {
        return id + "," + name + "," + department + "," + salary;
    }

    public static Employee toEmployee(String data) {
        String[] parts = data.split(",");
        int id = Integer.parseInt(parts[0]);
        String name = parts[1];
        String department = parts[2];
        double salary = Double.parseDouble(parts[3]);
        return new Employee(id, name, department, salary);
    }
}

public class EmployeeManagementSystem {
    private static final String FILE_NAME = "employees.txt";

    public void addEmployee(Employee emp) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(emp.toString());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void viewEmployees() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                Employee emp = Employee.toEmployee(line);
                System.out.println("ID: " + emp.getId() + ", Name: " + emp.getName() + ", Department: " + emp.getDepartment() + ", Salary: " + emp.getSalary());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void searchEmployeeById(int id) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                Employee emp = Employee.toEmployee(line);
                if (emp.getId() == id) {
                    System.out.println("ID: " + emp.getId() + ", Name: " + emp.getName() + ", Department: " + emp.getDepartment() + ", Salary: " + emp.getSalary());
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Employee not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(int id, Employee updatedEmp) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                Employee emp = Employee.toEmployee(line);
                if (emp.getId() == id) {
                    lines.add(updatedEmp.toString());
                } else {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String l : lines) {
                bw.write(l);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                Employee emp = Employee.toEmployee(line);
                if (emp.getId() != id) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String l : lines) {
                bw.write(l);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
