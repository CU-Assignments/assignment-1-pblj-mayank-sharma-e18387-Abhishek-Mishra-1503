import java.util.Scanner;

class BankAccount {
    private String name;
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw with overdraft check
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance! Withdrawal failed.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }

    // Display account details
    public void displayAccountDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Name: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Account creation
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter account number: ");
        String accNumber = sc.nextLine();

        System.out.print("Enter initial balance: ");
        double initialBalance = sc.nextDouble();

        BankAccount account = new BankAccount(name, accNumber, initialBalance);

        int choice;
        do {
            System.out.println("\n--- Banking Menu ---");
            System.out.println("1. Display Account Details");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    account.displayAccountDetails();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double wd = sc.nextDouble();
                    account.withdraw(wd);
                    break;
                case 4:
                    System.out.println("Thank you for banking with us!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}
