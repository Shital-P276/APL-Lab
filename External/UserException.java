import java.util.Scanner;
import java.util.*;
//USER DEFINED EXCEPTIONS
class NegativeNumException extends Exception{
public NegativeNumException(String msg){
	super(msg);
	}
}

class DivisionByZeroException extends Exception{
public DivisionByZeroException(String msg){
	super(msg);
	}
}

public class UserException{



	public static int add(int a, int b){
		return a+b;
	}

	public static int sub(int a, int b){
		return a-b;
	}

	public static int mul(int a, int b){
		return a*b;
	}

	public static int div(int a, int b)throws DivisionByZeroException {
		if(b==0){
			throw new DivisionByZeroException("Can't Divide By Zero!");
		}
		return a/b;
	}

	public static void main(String[] args){

		Scanner scn = new Scanner(System.in);
		try{
			System.out.println("Enter First Number : ");
			int a = scn.nextInt();
			if(a < 0){throw new NegativeNumException("Enter +ve number!"); }

			System.out.println("Enter Second Number : ");
			int b = scn.nextInt();
			if(b < 0){throw new NegativeNumException("Enter +ve number!"); }

			System.out.println("Addition : "+add(a,b));
			System.out.println("Subatraction  : "+sub(a,b));
			System.out.println("Multiplication: "+mul(a,b));
			try{
				System.out.println("Division: "+div(a,b));
			}catch(DivisionByZeroException e){
				System.out.println("Error During diviosion!");
				e.printStackTrace();
			}
			

		}catch(InputMismatchException e ){
			System.out.println("Enter valid Input!");
			e.printStackTrace();
		}catch(NegativeNumException e ){
			System.out.println("Enter a +ve num!");
			e.printStackTrace();
		}finally{
			scn.close();
			
		}
		System.out.println("Program closed!");

	}
}