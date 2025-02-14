package com.week4.day4;
import java.util.*;

// Custom Exception for Insufficient Balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// BankAccount Class
class BankAccount {
    private double balance;

    //Constructor
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to withdraw an amount
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }
}

public class BankTransactionSystem {
    public static void main(String[] args) {

        //create a scanner object
        Scanner scanner = new Scanner(System.in);

        //enter the initial balance
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        //create object of Bank Account
        BankAccount account = new BankAccount(initialBalance);

            System.out.println("\nCurrent balance: " + account.getBalance());
            System.out.print("Enter amount to withdraw (or enter 0 to exit): ");
            double amount = scanner.nextDouble();

            if (amount == 0) {
                System.out.println("Exiting. Thank you!");
            }

            try {
                //call the method to withdraw amount
                account.withdraw(amount);
            } catch (InsufficientBalanceException e) {
                System.out.println("Exception: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Exception: " + e.getMessage());
            } finally {
                scanner.close();
            }


    }
}


