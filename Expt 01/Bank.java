
import java.util.Scanner;
import java.util.ArrayList;

class BankAccount{
    private String accNum;
    private String accHolder;
    private double balance;

    private static int totalAcc = 0;
    private static double totalBalance = 0;

    public BankAccount(String accNum, String accHolder, double ibalance) {
        this.accNum = accNum;
        this.accHolder = accHolder;
        this.balance = ibalance;

        totalAcc += 1;
        totalBalance += ibalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            totalBalance += amount;
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            totalBalance -= amount;
            System.out.println("Withdrawal successful!");
        } else if (amount > balance) {
            System.out.println("Insufficient funds for withdrawal.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }

    public static void showTotalAccountsAndBalance() {
        System.out.printf("Total Accounts: %d\n", totalAcc);
        System.out.printf("Total Balance: %.2f\n", totalBalance);
    }

    public String getAccNum() {
        return accNum;
    }

    public String getAccHolder() {
        return accHolder;
    }

}

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>(); // Using ArrayList for dynamic storage

        System.out.println("\nWelcome to the Bank Account System!");

        while (true) {
            // Display menu
            System.out.println("\nMenu:");
            System.out.println(" 1. Create a new account");
            System.out.println(" 2. Deposit money into an account");
            System.out.println(" 3. Withdraw money from an account");
            System.out.println(" 4. Check balance of an account");
            System.out.println(" 5. Show total accounts and total balance");
            System.out.println(" 6. Exit");
            System.out.print("Enter your choice (1-6): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline
            System.out.println();

            switch (choice) {
                case 1: // Create new account
                    System.out.print("Enter Account Holder's Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Account Number: ");
                    String accNumber = scanner.nextLine();
                    System.out.print("Enter Initial Deposit: ");
                    double deposit = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline

                    BankAccount newAccount = new BankAccount(accNumber, name, deposit);
                    accounts.add(newAccount); // Add account to the ArrayList
                    System.out.println("Account created successfully!");
                    break;

                case 2: // Deposit money
                    System.out.print("Enter Account Number: ");
                    String depositAccNumber = scanner.nextLine();
                    BankAccount depositAccount = null;
                    for (BankAccount account : accounts) {
                        if (account.getAccNum().trim().equals(depositAccNumber.trim())) {
                            depositAccount = account;
                            break;
                        }
                    }
                    if (depositAccount != null) {
                        System.out.print("Enter Amount to Deposit: ");
                        double depositAmount = scanner.nextDouble();
                        scanner.nextLine(); // Consume the newline
                        depositAccount.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3: // Withdraw money
                    System.out.print("Enter Account Number: ");
                    String withdrawAccNumber = scanner.nextLine();
                    BankAccount withdrawAccount = null;
                    for (BankAccount account : accounts) {
                        if (account.getAccNum().trim().equals(withdrawAccNumber.trim())) {
                            withdrawAccount = account;
                            break;
                        }
                    }
                    if (withdrawAccount != null) {
                        System.out.print("Enter Amount to Withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        scanner.nextLine(); // Consume the newline
                        withdrawAccount.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4: // Check balance
                    System.out.print("Enter Account Number: ");
                    String balanceAccNumber = scanner.nextLine();
                    BankAccount balanceAccount = null;
                    for (BankAccount account : accounts) {
                        if (account.getAccNum().equals(balanceAccNumber)) {
                            balanceAccount = account;
                            break;
                        }
                    }
                    if (balanceAccount != null) {
                        balanceAccount.checkBalance();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5: // Show total accounts and total balance
                    BankAccount.showTotalAccountsAndBalance();
                    break;

                case 6: // Exit
                    System.out.println("Exiting the system. Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
