import java.util.*;

// User-defined exception for negative numbers
class NegativeNumberException extends Exception {
    public NegativeNumberException(String msg) {
        super(msg);
    }
}
class DivisionByZeroException extends Exception {
    public DivisionByZeroException(String msg) {
        super(msg);
    }
}

public class SimpleCalculatorException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter first positive number: ");
            int a = sc.nextInt();
            if (a < 0) throw new NegativeNumberException("Negative numbers not allowed.");

            System.out.print("Enter second positive number: ");
            int b = sc.nextInt();
            if (b < 0) throw new NegativeNumberException("Negative numbers not allowed.");

            System.out.println("Addition: " + (a + b));
            System.out.println("Subtraction: " + (a - b));
            System.out.println("Multiplication: " + (a * b));

            if (b == 0) {
                System.out.println("Cannot divide by zero.");
            } else {
                System.out.println("Division: " + ((double) a / b));
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter integers only.");
        } catch (NegativeNumberException e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            sc.close();
            System.out.println("Scanner closed.");
        }

        System.out.println("Program finished.");
    }
}
