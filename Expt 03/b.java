import java.util.Scanner;

abstract class Person{
    abstract void Gender();

    void Details() {
        System.out.println("Person Is Human Being ");
    }
}
class Boy extends Person{
    void Gender() {
        System.out.println("Person is a Boy");
    }
}
class Girl extends Person{
    void Gender() {
        System.out.println("Person is a Girl");
    }

}

public class Assignment3b {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.println(" Select Choice \n 1 For Boy | 2 For Girl");
        int choice = scn.nextInt();
        Person p;   //created ref of parent class

        
        System.out.println("-----------------------");
        switch (choice) {
            case 1:
                p = new Boy();
                p.Gender();
                p.Details();
                break;
            case 2:
                p = new Girl();
                p.Gender();
                p.Details();
            break;
            case 3:
            System.out.println("Exiting...");
            break;
            default:
                System.out.println("Enter Valid Input");
        }
    }
}

