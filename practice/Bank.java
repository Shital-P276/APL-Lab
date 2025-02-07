import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    private static int totalAccounts = 0;
    private static double totalBalance = 0;

    public BankAccount(String accountNumber, String accountHolderName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;

        totalAccounts++;
        totalBalance += initialDeposit;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        totalBalance += amount;
        System.out.println("Deposit successful!");
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            totalBalance -= amount;
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void checkBalance() {
        System.out.println("Account Balance: " + balance);
    }

    public static void displayTotalAccountsAndBalance() {
        System.out.println("Total Accounts: " + totalAccounts);
        System.out.println("Total Balance: " + String.format("%.2f", totalBalance));
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<BankAccount> accounts = new ArrayList<>();

        while (true) {
            System.out.println("\nWelcome to the Bank Account System!");
            System.out.println("Choose an option:");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money into an account");
            System.out.println("3. Withdraw money from an account");
            System.out.println("4. Check balance of an account");
            System.out.println("5. Show total accounts and total balance");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Holder's Name: ");
                    String accountHolderName = scanner.nextLine();
                    System.out.print("Enter Account Number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter Initial Deposit: ");
                    double initialDeposit = scanner.nextDouble();
                    scanner.nextLine();

                    BankAccount newAccount = new BankAccount(accountNumber, accountHolderName, initialDeposit);
                    accounts.add(newAccount);
                    System.out.println("Account created successfully!");
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    String depositAccountNumber = scanner.nextLine();
                    System.out.print("Enter Amount to Deposit: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();

                    BankAccount depositAccount = findAccount(accounts, depositAccountNumber);
                    if (depositAccount != null) {
                        depositAccount.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    String withdrawAccountNumber = scanner.nextLine();
                    System.out.print("Enter Amount to Withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();

                    BankAccount withdrawAccount = findAccount(accounts, withdrawAccountNumber);
                    if (withdrawAccount != null) {
                        withdrawAccount.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    String checkBalanceAccountNumber = scanner.nextLine();

                    BankAccount checkBalanceAccount = findAccount(accounts, checkBalanceAccountNumber);
                    if (checkBalanceAccount != null) {
                        checkBalanceAccount.checkBalance();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    BankAccount.displayTotalAccountsAndBalance();
                    break;

                case 6:
                    System.out.println("Exiting the system. Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }

    private static BankAccount findAccount(List<BankAccount> accounts, String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}
