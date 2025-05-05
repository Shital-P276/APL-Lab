import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class ListExample1{
	public static void main(String[] args){
	List<String> Company = new ArrayList<>();
	operations(Company);
	

	}
	public static void operations(List<String> companylist){
		companylist.add("BMW");
		companylist.add("Audi");
		companylist.add("Porsche");
		companylist.add("TATA");   //ADDING ELEMENTS IN LIST
		System.out.println("List: " + companylist);

		companylist.add(2,"Mahindra");  //ADDING ELEMENT BY INDEX 
		System.out.println("List: " + companylist);
		
		String Elementatindex2 = companylist.get(2);  //GET ELEMNT AT THAT POSITION
		System.out.println("Element at index 2 : "+Elementatindex2);

		boolean statement = companylist.contains("BMW");//CHECHKING ELEMENT
		System.out.println("Does BMW in List : "+statement);

		int indexnum = companylist.indexOf("Mahindra"); //RETRIEVING INDEX OF ELMNT
		System.out.println("Index of Mahindra : "+ indexnum);

		companylist.set(3,"Toyota");  //UPDATING LIST
		System.out.println("List: " + companylist);
		
		companylist.remove("Audi");  //REMOVING ELEMENT
		System.out.println("List after removing Audi: " + companylist);

		companylist.remove(3);  //REMOVING BY INDEX
		System.out.println("List after removing 3rd index: " + companylist);

		companylist.clear();   //CLEARING LIST
		System.out.println(" After Clearing list:  " + companylist);
	
		boolean statement1 = companylist.isEmpty();  //CHECKING LIST IS EMPTY 
		System.out.println("Is list Empty: "+ statement1);
		


		
		

		
		
	}
}