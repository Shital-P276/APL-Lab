import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class person {
    public int id;
    public String name;

    public person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void disp() {
        System.out.println("ID: " + id + " Name: " + name);
    }
}

class teacher extends person {

    public teacher(int id, String name, int salary) {
        super(id, name);
        this.salary = salary;
    }

    public int salary;

    @Override
    void disp() {
        System.out.println("ID: " + id + " Name: " + name + " Salary: " + salary);
    }
}

class student {
    public int fees;

    public student(int id, String name, int fees) {
        super(id, name);
        this.fees = fees;
    }

    @Override
    void disp() {
        System.out.println("ID: " + id + " Name: " + name + " Fees: " + fees);
    }
}

public class halo {
    static Scanner scn = new Scanner(System.in);
    static ArrayList<person> people = new ArrayList<>();
    public static void main(String args[]) {
        

        while (true) {
            System.out.println("School Management System:\nMenu:\n 1] Add Teacher\n 2] Add Student \n 3] Display teachers \n 4] Display Students \n 5] Exit \nEnter your choice: ");
            int choice = scn.nextInt();
            switch (choice) {
                case 1:
                    addTeacher();
                    break;
                    
                case 2:
                    addStudent();
                    break;
                    
                case 3:
                    dispTeach();
                    break;
                
                case 4:
                    dispStud();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid input please retry...");
                    break;
            }
        }
    }

    public static void addTeacher() {
        System.out.println("Add Teacher:\n  Enter ID:");
        int ID = scn.nextInt();
        scn.nextLine();
        
        System.out.println("  Enter Name:");
        String name = scn.nextLine();

        System.out.println("  Enter Salary: ");
        int salary = scn.nextInt();
        scn.nextLine();

        people.add(new teacher(ID, name, salary));
        System.out.println("Teacher added succesfully.");
    }

    public static void addStudent() {
        System.out.println("Add Student:\n  Enter ID:");
        int ID = scn.nextInt();
        scn.nextLine();
        
        System.out.println("  Enter Name:");
        String name = scn.nextLine();

        System.out.println("  Enter Fees: ");
        int fees = scn.nextInt();
        scn.nextLine();

        people.add(new student(ID, name, fees));
        System.out.println("Student added succesfully.");
    }

    public static void dispTeach() {
        System.out.println("List of Teachers:");
        boolean found = false;
        for(person p : people){
            if(p instanceof teacher){
                p.disp();
                found = true;
            }
        }
        if (!found){
            System.out.println("No Teacher Found...");
        }
    }

    
    public static void dispStud() {
        System.out.println("List of Teachers:");
        boolean found = false;
        for(person p : people){
            if(p instanceof student){
                p.disp();
                found = true;
            }
        }
        if (!found){
            System.out.println("No Student Found...");
        }
    }
}
