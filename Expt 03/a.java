
//Name:Samyak Nitin Wadmare
//SYB44 B-II Batch
//write a simple program to implement inheritance using super keyword and super() call 


import java.util.Scanner;
class Car{
    String company;
    Car(String Company) {
        this.company=Company;
    }
    void displaycompany() {
        System.out.println("Company Name: "+ company);
    }
}
class Model extends Car{
    String Model;
    Model(String companyname,String model) {
        super(companyname);      //calling the constructor of Parent class
        this.Model=model;
    }
    void DisplayDetails() {
        super.displaycompany();   //calling the method of parent class by super keyword
        System.out.println("Model : "+ Model);
    }

}
public class Assignment3a {
    
    public static void main(String[] args) {

        String ComName;
        String Modelname;
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter Company Of The CAR: ");
        ComName=scn.nextLine();

        System.out.println("Enter MODEL Of The Car: ");
        Modelname=scn.nextLine();

        Model myModel = new Model(ComName, Modelname);
        myModel.DisplayDetails();



    }
}

