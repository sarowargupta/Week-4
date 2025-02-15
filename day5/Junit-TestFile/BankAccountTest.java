package com.week4.day5.junit;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void testDeposit() {
        BankAccount account = new BankAccount(100.0);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        BankAccount account = new BankAccount(100.0);
        account.withdraw(40.0);
        assertEquals(60.0, account.getBalance());
    }

    @Test
    public void testWithdraw_InsufficientBalance() {
        BankAccount account = new BankAccount(50.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(100.0));
    }

    @Test
    public void testDeposit_NegativeAmount() {
        BankAccount account = new BankAccount(100.0);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-10.0));
    }

    @Test
    public void testWithdraw_NegativeAmount() {
        BankAccount account = new BankAccount(100.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-20.0));
    }
}
