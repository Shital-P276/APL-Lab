import java.util.*;

public class BankAccount {
    // Instance variables
    private int accountNumber;
    private double balance;

    // Static variables
    private static String bankName;
    private static double interestRate;

    // Constructor
    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Static methods to get and set static variables
    public static String fetchBankName() {
        return bankName;
    }

    public static void assignBankName(String name) {
        bankName = name;
    }

    public static double grabInterestRate() {
        return interestRate;
    }

    public static void designateInterestRate(double rate) {
        interestRate = rate;
    }

    // Member method to calculate total interest
    public double computeTotalInterest() {
        return balance * interestRate / 100;
    }

    // Method to display account details along with static variables
    public void displayAccountDetails() {
        System.out.println("Bank: " + fetchBankName());
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("Interest Rate: " + grabInterestRate() + "%");
        System.out.println("Total Interest: " + computeTotalInterest());
    }

    // Main method to demonstrate the program
    public static void main(String[] args) {
        // Setting static variables
        BankAccount.assignBankName("Global Bank");
        BankAccount.designateInterestRate(5.0);

        // Creating BankAccount objects
        BankAccount account1 = new BankAccount(12345, 10000.00);
        BankAccount account2 = new BankAccount(67890, 20000.00);

        // Printing account details
        account1.displayAccountDetails();
        System.out.println();
        account2.displayAccountDetails();
    }
}