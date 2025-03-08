import java.util.Scanner;

public class StringOps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString;

        while (true) {
            // Display menu
            System.out.println("\n--- String Operations Menu ---");
            System.out.println("1. Reverse a string");
            System.out.println("2. Convert to uppercase");
            System.out.println("3. Convert to lowercase");
            System.out.println("4. Find string length");
            System.out.println("5. Check if string is empty");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character left by nextInt()

            switch (choice) {
                case 1:
                    System.out.print("Enter a string to reverse: ");
                    inputString = scanner.nextLine();
                    System.out.println("Reversed string: " + reverseString(inputString));
                    break;
                case 2:
                    System.out.print("Enter a string to convert to uppercase: ");
                    inputString = scanner.nextLine();
                    System.out.println("Uppercase string: " + inputString.toUpperCase());
                    break;
                case 3:
                    System.out.print("Enter a string to convert to lowercase: ");
                    inputString = scanner.nextLine();
                    System.out.println("Lowercase string: " + inputString.toLowerCase());
                    break;
                case 4:
                    System.out.print("Enter a string to find the length: ");
                    inputString = scanner.nextLine();
                    System.out.println("Length of the string: " + inputString.length());
                    break;
                case 5:
                    System.out.print("Enter a string to check if it's empty: ");
                    inputString = scanner.nextLine();
                    if (inputString.isEmpty()) {
                        System.out.println("The string is empty.");
                    } else {
                        System.out.println("The string is not empty.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to reverse a string
    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }
}
