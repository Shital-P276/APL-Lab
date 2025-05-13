public class Constructor {
    public static class Student {
        // Fields / Attributes
        String name;
        int age;

        // 1. Default Constructor
        Student() {
            name = "Unknown";
            age = 0;
        }

        // 2. Parameterized Constructor
        Student(String n, int a) {
            name = n;
            age = a;
        }

        // 3. Copy Constructor
        Student(Student s) {
            name = s.name;
            age = s.age;
        }

        // Method to display student info
        void display() {
            System.out.println("Name: " + name + ", Age: " + age);
        }
    }

    public static void main(String[] args) {
        // Using default constructor
        Student s1 = new Student();
        s1.display();

        // Using parameterized constructor
        Student s2 = new Student("Alice", 20);
        s2.display();

        // Using copy constructor
        Student s3 = new Student(s2);
        s3.display();
    }
}