package com.week4.day2.map;
import java.util.*;

public class BankingSystem {
    // HashMap to store account balances (AccountNumber -> Balance)
    private Map<Integer, Double> accounts;

    // TreeMap to sort accounts by balance
    private TreeMap<Integer, Double> sortedAccounts;

    // Queue to process withdrawal requests
    private Queue<WithdrawalRequest> withdrawalQueue;

    public BankingSystem() {
        accounts = new HashMap<>();
        sortedAccounts = new TreeMap<>(Comparator.comparing(accounts::get)); // Sort by balance
        withdrawalQueue = new LinkedList<>();
    }

    // Method to create a new account
    public void createAccount(int accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
        System.out.println("Account created: Account Number " + accountNumber + ", Balance: $" + initialBalance);
    }

    // Method to display all accounts sorted by balance
    public void displayAccountsSortedByBalance() {
        sortedAccounts.putAll(accounts); // Copy accounts to TreeMap
        System.out.println("Accounts sorted by balance:");
        for (Map.Entry<Integer, Double> entry : sortedAccounts.entrySet()) {
            System.out.println("Account " + entry.getKey() + " -> Balance: $" + entry.getValue());
        }
    }

    // Method to add a withdrawal request to the queue
    public void requestWithdrawal(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(new WithdrawalRequest(accountNumber, amount));
            System.out.println("Withdrawal request added for Account " + accountNumber + " -> Amount: $" + amount);
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

    // Method to process all withdrawal requests in the queue
    public void processWithdrawals() {
        System.out.println("Processing withdrawal requests...");
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest request = withdrawalQueue.poll();
            int accountNumber = request.getAccountNumber();
            double amount = request.getAmount();

            if (accounts.get(accountNumber) >= amount) {
                accounts.put(accountNumber, accounts.get(accountNumber) - amount);
                System.out.println("Withdrawal successful for Account " + accountNumber + " -> Amount: $" + amount);
            } else {
                System.out.println("Insufficient funds for Account " + accountNumber + " -> Requested: $" + amount + ", Available: $" + accounts.get(accountNumber));
            }
        }
    }
    //method for testing
    public double getBalance(int accountNumber) {
        return accounts.getOrDefault(accountNumber, 0.0);
    }


    // Inner class for withdrawal request
    private static class WithdrawalRequest {
        private int accountNumber;
        private double amount;

        public WithdrawalRequest(int accountNumber, double amount) {
            this.accountNumber = accountNumber;
            this.amount = amount;
        }

        public int getAccountNumber() {
            return accountNumber;
        }

        public double getAmount() {
            return amount;
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // Create accounts
        bank.createAccount(101, 1000.00);
        bank.createAccount(102, 500.00);
        bank.createAccount(103, 1500.00);
        bank.createAccount(104, 750.00);

        // Display accounts sorted by balance
        System.out.println();
        bank.displayAccountsSortedByBalance();

        // Request withdrawals
        System.out.println();
        bank.requestWithdrawal(101, 200.00);
        bank.requestWithdrawal(102, 600.00);  // Insufficient funds
        bank.requestWithdrawal(103, 1000.00);

        // Process withdrawals
        System.out.println();
        bank.processWithdrawals();

        // Display accounts sorted by balance after withdrawals
        System.out.println();
        bank.displayAccountsSortedByBalance();
    }
}
