import java.util.Date;

public class Account{
    // Data fields
    private int id;
    private double balance;
    private static double annualInterestRate; // Shared by all accounts
    private Date dateCreated;

    // No-arg constructor that creates a default account
    public Account() {
        this.id = 0;
        this.balance = 0.0;
        this.dateCreated = new Date(); // Set to current date
    }

    // Constructor that creates an account with specified id and balance
    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.dateCreated = new Date(); // Set to current date
    }

    // Accessor and mutator methods for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Accessor and mutator methods for balance
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Accessor and mutator methods for annualInterestRate
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }

    // Accessor method for dateCreated
    public Date getDateCreated() {
        return dateCreated;
    }

    // Method that returns the monthly interest rate
    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    // Method that returns the monthly interest
    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate() / 100;
    }

    // Method that withdraws a specified amount from the account
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    // Method that deposits a specified amount to the account
    public void deposit(double amount) {
        balance += amount;
    }
}
