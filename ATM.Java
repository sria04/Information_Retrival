import java.util.Scanner;
import java.util.Date;

public class ATM {
    public static void main(String[] args) {
        // Step 1: Create 10 accounts with initial balance of $100
        Account[] accounts = new Account[10];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, 100);  // Initialize each account with ID and $100 balance
        }

        Scanner input = new Scanner(System.in);

        // Step 2: Continuous loop for ATM operations
        while (true) {
            // Step 2.1: Get valid account ID
            int id = getValidID(input, accounts);

            // Step 2.2: Display and process menu for the selected account
            showMenu(accounts[id], input);
        }
    }

    // Method to get a valid account ID (between 0 and 9)
    public static int getValidID(Scanner input, Account[] accounts) {
        int id;
        while (true) {
            System.out.print("Enter an account ID (0-9): ");
            id = input.nextInt();
            if (id >= 0 && id < accounts.length) {
                break;  // Valid ID, exit loop
            } else {
                System.out.println("Invalid ID. Please try again.");
            }
        }
        return id;
    }

    // Method to show the ATM menu for a given account
    public static void showMenu(Account account, Scanner input) {
        int choice;
        do {
            // Step 3: Display menu options
            System.out.println("\nMain Menu:");
            System.out.println("1: View current balance");
            System.out.println("2: Withdraw money");
            System.out.println("3: Deposit money");
            System.out.println("4: Exit");

            System.out.print("Enter a choice: ");
            choice = input.nextInt();

            // Step 4: Process user choice
            switch (choice) {
                case 1:
                    System.out.println("The current balance is: $" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: $");
                    double withdrawAmount = input.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: $");
                    double depositAmount = input.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 4:
                    System.out.println("Exiting to ID prompt...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);  // Loop until the user chooses to exit
    }
}

// The Account class from Programming Exercise 9.7
class Account {
    private int id;
    private double balance;
    private static double annualInterestRate = 0;
    private Date dateCreated;

    // Constructor for default account
    public Account() {
        this(0, 0);  // Default values
    }

    // Constructor with specified id and balance
    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.dateCreated = new Date();
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Setter for ID
    public void setId(int id) {
        this.id = id;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Setter for balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Getter for annual interest rate
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    // Setter for annual interest rate
    public static void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }

    // Method to get the monthly interest rate
    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    // Method to calculate the monthly interest
    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate();
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        }
    }

    // Method to deposit money
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: $" + balance);
    }

    // Getter for date created
    public Date getDateCreated() {
        return dateCreated;
    }
}
