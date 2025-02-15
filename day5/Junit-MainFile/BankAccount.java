package com.week4.day5.junit;
import java.util.*;
public class BankAccount {
    private double balance;

    // Constructor to initialize balance
    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }


    public static void main(String[] args) {
        //create a scanner object
        Scanner sc = new Scanner(System.in);
        try {
            //take initial amount
            System.out.println("Enter initial balance in the account");
            double initialBalance = sc.nextDouble();
            BankAccount account = new BankAccount(initialBalance);

            //take amount to be deposited
            System.out.println("Enter amount to be deposit:");
            double depositAmount = sc.nextDouble();
            //call the method
            account.deposit(depositAmount);
            //print the result after deposit amount
            System.out.println("Balance after deposit: " + account.getBalance());

            //take amount to be withdrawn
            System.out.println("Enter amount to be withdrawn:");
            double withdrawAmount = sc.nextDouble();
            //call the method
            account.withdraw(withdrawAmount);
            //print the result
            System.out.println("Balance after withdrawal: " + account.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }

    }

}