import java.util.Scanner;

public class StringOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String str1 = sc.nextLine();

        // Display length
        System.out.println("Length of the string: " + str1.length());

        // Convert to upper case
        System.out.println("Uppercase: " + str1.toUpperCase());

        // Convert to lower case
        System.out.println("Lowercase: " + str1.toLowerCase());

        // Character at a specific index
        if (str1.length() > 2) {
            System.out.println("Character at index 2: " + str1.charAt(2));
        }

        // Substring
        if (str1.length() >= 5) {
            System.out.println("Substring (1 to 4): " + str1.substring(1, 5));
        }

        // Concatenation
        System.out.print("Enter another string to concatenate: ");
        String str2 = sc.nextLine();
        String concatenated = str1.concat(" " + str2);
        System.out.println("Concatenated string: " + concatenated);

        // Equality check
        System.out.print("Enter another string to compare: ");
        String str3 = sc.nextLine();
        if (str1.equals(str3)) {
            System.out.println("The strings are equal.");
        } else {
            System.out.println("The strings are not equal.");
        }

        // Reverse the string
        String reversed = new StringBuilder(str1).reverse().toString();
        System.out.println("Reversed string: " + reversed);
    }
}
