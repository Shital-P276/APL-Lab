import java.util.InputMismatchException;
import java.util.Scanner;

class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}

class DivisionByZeroException extends Exception {
    public DivisionByZeroException(String message) {
        super(message);
    }
}

public class ArithmeticOperationsWithExceptions {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double divide(int a, int b) throws DivisionByZeroException {
        if (b == 0) {
            throw new DivisionByZeroException("Cannot divide by zero."); 
        }
        return (double) a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the first number: ");
            int num1 = scanner.nextInt();
            if (num1 < 0) {
                throw new NegativeNumberException("First number cannot be negative.");
            }
            System.out.print("Enter the second number: ");
            int num2 = scanner.nextInt();
            if (num2 < 0) {
                throw new NegativeNumberException("Second number cannot be negative.");
            }

            System.out.println("Performing arithmetic operations:");
            System.out.println("Addition: " + add(num1, num2));
            System.out.println("Subtraction: " + subtract(num1, num2));
            System.out.println("Multiplication: " + multiply(num1, num2));

            try {
                System.out.println("Division: " + divide(num1, num2));
            } catch (DivisionByZeroException e) {
                System.err.println("Error during division: " + e.getMessage()); 
            }
        } catch (InputMismatchException e) {
            System.err.println("Error: Invalid input. Please enter integers only.");
        } catch (NegativeNumberException e) {
            System.err.println("Error: " + e.getMessage()); 
        } finally {
            scanner.close();
            System.out.println("Scanner closed.");
        }
        System.out.println("End of program.");
    }
}
