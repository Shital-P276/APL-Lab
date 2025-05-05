import java.io.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileDemo1 {

	public static void main(String[] args) {
	Scanner scn = new Scanner (System.in);
	String myfile = "sample1.txt";

	System.out.println("Enter text to write in file (or enter exit):");
	writetofile(myfile,scn);

	System.out.println("Displaying file  : ");
	readisplay(myfile);
	

	System.out.println("Enter text to Append in file (or enter exit): ");
	appendtofile(myfile,scn);

	System.out.println("Displaying file  : ");
	readisplay(myfile);


	scn.close();
	}
	public static void writetofile(String myfile,Scanner scn) {
	try(FileWriter Writer = new FileWriter(myfile)){
		while(true) {
		String line = scn.nextLine();
		if(line.equalsIgnoreCase("exit")) break;
		Writer.write(line+"\n");
		}

	} catch(IOException e) {
	System.out.println("Error while Writing");
	e.printStackTrace();
	}

	}
	public static void appendtofile(String myfile,Scanner scn) {
	try(FileWriter Writer = new FileWriter(myfile,true)){
		while(true) {
		String line = scn.nextLine();
		if(line.equalsIgnoreCase("exit")) break;
		Writer.write(line+"\n");
		}

	} catch(IOException e) {
	System.out.println("Error while Writing");
	e.printStackTrace();
	}
	}
	
	public static void readisplay(String myfile){
	try(Scanner myreader = new Scanner(new File(myfile))){
		while(myreader.hasNextLine()) {
		String data = myreader.nextLine();
		System.out.println(data);
		}
	myreader.close();
	}catch(FileNotFoundException e){
	System.out.println("Error while reading");
	e.printStackTrace();
	}
	}


}