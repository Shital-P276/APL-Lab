import java.io.*;
import java.util.Scanner;

class student{
    private String Name;
    private int Roll;

    public void setStudent(String nm,int rl){
        Name = nm;
        Roll = rl;
    }

    public void getStudent(){
        System.out.println("Name: "+ Name + "\nRoll No:" + Roll);
    }


    // public void listStudent(){
    //     for (student stdkid: stdarr) {
    //         System.out.println("Name: "+ stdkid.Name + "\nRoll No:" + stdkid.Roll);
    //     }
    // }
}

public class obj2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        student[] std = new student[50];

        char choice;
        int cnt = 0;

        while (True) {
            System.out.println();
            choice = scn.next().charAt(0);
            switch (choice) {
                case A:
                    System.out.println("Add Student :\n");
                    String nm = scn.next();
                    int rl = scn.nextInt();
                    std[cnt] = new student();
                    std[cnt].setStudent(nm,rl);
                    cnt++;
                    break;
                
                case D:
                    System.out.println("Display Student :\n");
                    int i = scn.nextInt();
                    std[i].getStudent();
                    break;

                case Q:
                    System.out.println("Quitting...");
                    scn.close();
                    System.exit(0);
                    break;

                    
            
                default:
                    System.out.println("Invalid Input please try again");
                    break;
            }
        }   
    }
    
}